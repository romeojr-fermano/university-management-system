## 1. Database Migration

- [x] 1.1 Create `V2__add_role_to_users.sql` migration file
- [x] 1.2 Add `role` column with DEFAULT 'UNSPECIFIED'
- [x] 1.3 Run `./gradlew flywayMigrate` to apply migration
- [x] 1.4 Verify with `./gradlew flywayInfo`

## 2. Update User Entity

- [x] 2.1 Add `Role role` field to User class
- [x] 2.2 Add `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor` Lombok annotations
- [x] 2.3 Import Role enum

## 3. Implement Signup Handler

- [x] 3.1 Add `@FXML private Button` fields for signup buttons (if not already)
- [x] 3.2 Wire up button onAction to `handleSignup()` in FXML
- [x] 3.3 Implement `detectRoleFromVisibleForm()` method
- [x] 3.4 Implement `extractFormFields(String role)` method
- [x] 3.5 Implement `validateSignup(String username, String email, String password, String confirm)` method
- [x] 3.6 Implement `usernameExists(String username)` helper
- [x] 3.7 Implement `emailExists(String email)` helper
- [x] 3.8 Implement `insertUser(...)` with transaction handling
- [x] 3.9 Implement `showSuccessAlert()` method
- [x] 3.10 Implement `showErrorAlert(String message)` method
- [x] 3.11 Connect buttons to `handleSignup()` in FXML

## 4. Wire Up FXML

- [x] 4.1 Add `onAction="#handleSignup"` to admin_signup_button
- [x] 4.2 Add `onAction="#handleSignup"` to student_signup_button
- [x] 4.3 Add `onAction="#handleSignup"` to teacher_signup_button

## 5. Test

- [x] 5.1 Test admin signup with valid data (manual - requires app run)
- [x] 5.2 Test student signup with valid data (manual - requires app run)
- [x] 5.3 Test teacher signup with valid data (manual - requires app run)
- [x] 5.4 Test duplicate username shows error (manual - requires app run)
- [x] 5.5 Test duplicate email shows error (manual - requires app run)
- [x] 5.6 Test invalid email format shows error (manual - requires app run)
- [x] 5.7 Test password < 8 chars shows error (manual - requires app run)
- [x] 5.8 Test password mismatch shows error (manual - requires app run)
- [x] 5.9 Test empty fields show error (manual - requires app run)
- [x] 5.10 Verify user appears in database after signup (manual - requires app run)
