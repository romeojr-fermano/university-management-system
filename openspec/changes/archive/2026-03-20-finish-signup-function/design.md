## Context

The UI has three signup forms (Admin, Student, Teacher) with input fields and signup buttons, but no backend logic. The database has a `users` table without a `role` column. The codebase uses SQLite, Flyway for migrations, and follows a simple pattern without a service layer.

**Constraints:**
- Desktop JavaFX app (not web/server)
- SQLite database (file-based, local)
- Flyway for migrations
- Lombok for boilerplate reduction
- DRY principle: single handler for all three forms

## Goals / Non-Goals

**Goals:**
- Complete signup flow: validate → check uniqueness → insert → alert → navigate
- Strict validation: email format, password length, field requirements
- Transaction safety: rollback on any DB failure
- Clear user feedback via alerts
- DRY implementation: one `handleSignup()` method detects form context

**Non-Goals:**
- Password hashing (deferred to future change)
- Email verification
- Rate limiting
- Custom alert CSS styling (use default JavaFX alerts)
- Separate service/repository layer

## Decisions

### 1. Single Handler (DRY)

**Decision:** One `handleSignup()` method detects which form is visible and extracts role from context.

**Implementation:**
```java
@FXML
public void handleSignup() {
    String role = detectRoleFromVisibleForm();
    // extract fields based on role
    // validate
    // check uniqueness
    // insert
    // alert + navigate
}
```

**Alternatives Considered:**
- Three separate handlers (adminSignup, studentSignup, teacherSignup): Rejected - violates DRY
- Form-specific controllers: Rejected - overkill for this scope

**Rationale:** Matches codebase simplicity, reduces code duplication.

---

### 2. Check-Before-Insert Pattern

**Decision:** Check username and email uniqueness before INSERT, wrapped in transaction.

**Implementation:**
```java
conn.setAutoCommit(false);
try {
    if (usernameExists(username)) throw new ValidationException("Username exists");
    if (emailExists(email)) throw new ValidationException("Email exists");
    insertUser(...);
    conn.commit();
} catch (Exception e) {
    conn.rollback();
    throw e;
}
```

**Alternatives Considered:**
- Let DB fail with UNIQUE constraint: Rejected - unclear error messages
- Separate transactions for check and insert: Rejected - race condition possible

**Rationale:** Clear error messages, atomic operation, unlikely race condition for local desktop app.

---

### 3. Email Validation: HTML5 Standard Regex

**Decision:** Use the HTML5 standard email regex for validation.

**Regex:**
```java
"^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?(?:\\.[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?)*$"
```

**Alternatives Considered:**
- Strict RFC 5322: Rejected - too restrictive, rejects valid emails
- Lenient (just check @): Rejected - too permissive
- No validation: Rejected - data quality matters

**Rationale:** Industry standard, well-tested, balances permissiveness with correctness.

---

### 4. Password Policy: Length Only

**Decision:** Minimum 8 characters, no complexity requirements (uppercase, special chars, numbers).

**Rules:**
- Min length: 8 characters
- Max length: 72 (bcrypt limit preparation)
- No complexity: no uppercase, number, or special char requirements

**Alternatives Considered:**
- Complexity requirements (OWASP 2016): Rejected - UX poor, users work around
- 12+ characters: Considered but 8 is OWASP baseline

**Rationale:** OWASP 2023 recommends length over complexity. "correct horse battery staple" > "P@ssw0rd!"

---

### 5. Migration: ALTER TABLE with DEFAULT

**Decision:** Add `role` column with DEFAULT 'UNSPECIFIED' for existing rows.

**SQL:**
```sql
ALTER TABLE users ADD COLUMN role TEXT NOT NULL DEFAULT 'UNSPECIFIED';
```

**Alternatives Considered:**
- Drop and recreate table: Rejected - loses existing data
- Nullable column: Rejected - role should be required
- Multiple migrations: Rejected - too complex for this case

**Rationale:** SQLite requires DEFAULT for NOT NULL on existing tables. Safe for existing data.

---

### 6. Alert Style: Default JavaFX

**Decision:** Use standard JavaFX alerts with default styling.

**Types:**
- Validation errors: `AlertType.ERROR`
- Success: `AlertType.INFORMATION`

**Alternatives Considered:**
- Custom CSS matching LoginForm.css: Rejected - extra file, maintenance burden
- Inline styling: Rejected - not reusable

**Rationale:** MVP approach. Can enhance styling later if needed.

---

### 7. User Entity: Lombok @Data

**Decision:** Add Lombok annotations to User class.

**Implementation:**
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;
    String username;
    String password;
    String emailAddress;
    Role role;
}
```

**Rationale:** Lombok already in project. Reduces boilerplate.

---

### 8. Transaction Isolation

**Decision:** Use SQLite default (SERIALIZABLE).

**Rationale:** Desktop app, single user, local DB. Default isolation sufficient.

## Risks / Trade-offs

### [Risk] Race condition on uniqueness check
**Description:** Two simultaneous signups with same username could both pass check, one fails on INSERT.
**Mitigation:** Transaction with rollback. Only affects one request. Unlikely in desktop app.

### [Risk] SQLite ALTER TABLE idempotency
**Description:** Running migration twice will fail (column exists).
**Mitigation:** Flyway tracks applied migrations. Won't re-run. Document that migrations are one-time.

### [Risk] Plaintext passwords
**Description:** Passwords stored in cleartext in DB.
**Mitigation:** Document as known issue. Future change will add bcrypt hashing.

### [Trade-off] Check-then-insert vs INSERT-and-catch
**Pro:** Clear error messages, easy to implement
**Con:** Extra query, theoretical race condition

## Migration Plan

1. Create `V2__add_role_to_users.sql` in `src/main/resources/db/migration/`
2. Run `./gradlew flywayMigrate` to apply
3. Verify with `./gradlew flywayInfo`
4. Implement controller logic
5. Test signup for each role

**Rollback:**
```sql
-- Manual (not automated)
ALTER TABLE users DROP COLUMN role;
```
SQLite limitation: Can't easily drop columns. For local dev, acceptable to drop DB and re-migrate.

## Open Questions

1. **Username length limits?** Min 3, Max 50 suggested - confirm?
2. **Email max length?** RFC 5322 says 254 - enforce?
3. **Default role for existing users?** Using 'UNSPECIFIED' - acceptable?

These are minor and can be adjusted during implementation if needed.
