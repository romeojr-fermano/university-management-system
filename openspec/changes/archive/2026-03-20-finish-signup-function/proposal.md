## Why

The signup functionality for Admin, Student, and Teacher roles exists in the UI but is not wired up to the backend. The buttons are present but clicking them does nothing. This change completes the signup flow by implementing database operations, validation, and proper user feedback.

## What Changes

- Add `role` column to `users` table via Flyway migration
- Implement `handleSignup()` in `FXMLDocumentController` that detects current form (Admin/Student/Teacher)
- Add validation: email format (HTML5 regex), password length (8+ chars), password confirmation match, empty field checks
- Add uniqueness validation: check username and email don't already exist in DB
- Add transaction handling: rollback on any failure during check+insert
- Add user feedback: success/error alerts with appropriate AlertType
- Navigate to login form on successful signup
- Update `User` entity to include `role` field and add Lombok annotations

## Capabilities

### New Capabilities
- `user-signup`: Complete signup flow for all three roles (Admin, Student, Teacher) including validation and database persistence

### Modified Capabilities
- None - no existing capability requirements change

## Impact

- **Database**: New migration `V2__add_role_to_users.sql` adds `role` column
- **Controller**: New `handleSignup()` method added to `FXMLDocumentController`
- **Entity**: `User` class updated with `Role` field and Lombok annotations
- **UI**: Signup buttons now functional
- **Dependencies**: None (no new libraries)
- **Breaking**: None - new column has DEFAULT value for existing rows
