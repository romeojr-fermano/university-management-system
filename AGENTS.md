# AGENTS.md - University Management System

## Project Overview
JavaFX Desktop Application for university management. Built with Java 25, Gradle 9.4, JavaFX 25, SQLite, and Flyway migrations.

**Module:** `com.javafx.univesitymanagementsystem`

---

## Build, Test & Run Commands

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.javafx.univesitymanagementsystem.MyTestClass"

# Run a single test method
./gradlew test --tests "com.javafx.univesitymanagementsystem.MyTestClass.myTestMethod"

# Clean and rebuild
./gradlew clean build

# Create self-contained distribution
./gradlew jlink

# Run linting/formatting (if configured)
./gradlew check
```

---

## Code Style

### General
- **Java Format:** Google Java Style with IntelliJ IDEA (`.idea/google-java-format.xml`)
- **Encoding:** UTF-8 for all files
- **Line Ending:** Unix-style (LF)

### Java Naming Conventions
| Element | Convention | Example |
|---------|------------|---------|
| Classes | PascalCase | `UniversityManagementSystem`, `FXMLDocumentController` |
| Methods | camelCase | `switchSignupForm`, `signIn`, `roleList` |
| Variables | camelCase | `login_username`, `student_email_address` |
| Enums | PascalCase | `Role` |
| Enum values | PascalCase | `ADMIN`, `STUDENT` |
| Constants | UPPER_SNAKE_CASE | `DATABASE_URL` |

### Package Structure
```
com.javafx.univesitymanagementsystem/
├── database/         # Database utilities
├── user/             # User model/entity
├── config/           # Configuration classes
├── Role.java         # Enum
├── Launcher.java     # Entry point
└── UniversityManagementSystem.java  # Main application
```

### Import Ordering
1. `java.*` standard library
2. `javafx.*` JavaFX framework
3. Third-party libraries (`org.*`, `com.*`)
4. Local application imports

```java
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
```

---

## FXML Conventions

### Basic Structure
```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import org.kordamp.ikonli.javafx.*?>

<VBox xmlns="http://javafx.com/javafx/25" xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="com.javafx.univesitymanagementsystem.MyController">
  <TextField fx:id="myTextField"/>
  <Button fx:id="submitButton" onAction="#handleSubmit"/>
</VBox>
```

### fx:id Naming
- Use **snake_case** for `fx:id` attributes: `login_username`, `student_email_address`
- Match controller field names exactly
- Public fields use `public` modifier, private use `@FXML private`

```java
@FXML public AnchorPane login_form;
@FXML private TextField login_username;
@FXML private Button login_button;
```

### Ikonli Icons
```xml
<FontIcon iconLiteral="fa-user" iconSize="24" iconColor="white"/>
```

---

## JavaFX CSS Conventions

- Properties use `-fx-` prefix: `-fx-background-color`, `-fx-text-fill`
- Selectors: type (`.button`), ID (`#submit-btn`), class (`.warning-text`)
- Use `styleClass` attribute in FXML, not `id`
- Pseudo-classes: `.button:hover`, `.button:pressed`, `.text-field:focused`

```css
.button {
    -fx-background-color: #4CAF50;
    -fx-text-fill: white;
    -fx-font-size: 14px;
}

.button:hover {
    -fx-background-color: #45a049;
}
```

---

## Database Conventions

### Naming
- Tables: **snake_case** (e.g., `user_accounts`)
- Columns: **snake_case** (e.g., `email_address`, `created_at`)
- Primary keys: `id` (integer, auto-increment)

### Migrations
- Location: `src/main/resources/db/migration/`
- Naming: `V{n}__description.sql`
- Use Flyway for all schema changes

### Connection Pattern
```java
public static Connection connect() throws SQLException {
    return DriverManager.getConnection("jdbc:sqlite:university_management.sqlite");
}
```

---

## Error Handling

- Declare `throws SQLException` or `throws IOException` on methods
- Use try-with-resources for database connections and streams
- Show user-friendly alerts in JavaFX for runtime errors
- Log errors appropriately (use `System.err` or logging framework)

```java
public void myMethod() throws SQLException {
    try (Connection conn = Database.connect()) {
        // Use connection
    }
}
```

---

## Lombok Usage

- Use `@Data`, `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor` as needed
- Ensure annotation processor is configured (already set in `build.gradle`)

---

## Testing Guidelines

- Use **JUnit 5 (Jupiter)** for tests
- Place tests in `src/test/java/` matching the main source structure
- Test naming: `MethodName_Scenario_ExpectedResult`

---

## Key Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| JavaFX | 25.0.2 | UI framework |
| Ikonli | 12.4.0 | FontAwesome icons |
| SQLite JDBC | 3.51.2.0 | Database |
| Flyway | 12.1.0 | DB migrations |
| Lombok | 1.18.44 | Boilerplate reduction |
| JUnit Jupiter | 5.12.1 | Testing |

---

## Important Files

- `build.gradle` - Gradle build configuration
- `module-info.java` - Java module system descriptor
- `src/main/resources/db/migration/` - Flyway SQL migrations
- `skills/javafx-expert/` - JavaFX development guidelines

---

## Quick Reference

```bash
# Full build and test
./gradlew clean build test

# Run specific test
./gradlew test --tests "*TestClass"

# Create distribution
./gradlew jlink
```
