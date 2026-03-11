# University Management System (JavaFX)

A JavaFX-based University Management System built with Java 25 and Gradle. This project uses the Java Module System and incorporates modern UI elements like FontAwesome icons via the Ikonli library.

## Project Overview

- **Main Technology Stack:** Java 25, JavaFX 25, Gradle.
- **UI Architecture:** FXML for layout, CSS for styling, and Ikonli for icons.
- **Module Name:** `com.javafx.univesitymanagementsystem`
- **Main Class:** `com.javafx.univesitymanagementsystem.UniversityManagementSystem`

## Project Structure

- `src/main/java`: Java source files including the main application and module configuration.
- `src/main/resources`: UI resources (FXML files, CSS stylesheets).
- `build.gradle`: Project build configuration and dependencies.
- `FONTAWESOME_ICONS.md`: Documentation for using FontAwesome icons (Note: project uses Ikonli, which may differ slightly from the documentation).

## Building and Running

### Build the Project
```bash
./gradlew build
```

### Run the Application
```bash
./gradlew run
```

### Run Tests
```bash
./gradlew test
```

### Create a JLink Image
```bash
./gradlew jlink
```

## Development Conventions

- **Java Version:** Java 25 (configured in `build.gradle`).
- **UI Development:** 
  - Layouts are defined in `.fxml` files in `src/main/resources`.
  - Styling is handled by `.css` files in `src/main/resources/.../design`.
  - Icons use the Ikonli library with FontAwesome. Example: `<FontIcon iconLiteral="fa-user" ... />`.
- **Module System:** This project is fully modularized. Any new dependencies must be added to both `build.gradle` and `module-info.java`.
- **Entry Points:** 
  - `UniversityManagementSystem`: Main JavaFX application class.
  - `Launcher`: Helper class to launch the application.

## Key Dependencies

- `javafx.controls`: Standard JavaFX UI controls.
- `javafx.fxml`: FXML support.
- `org.kordamp.ikonli:ikonli-javafx`: Icon support for JavaFX.
- `org.kordamp.ikonli:ikonli-fontawesome-pack`: FontAwesome icon pack for Ikonli.
- `junit-jupiter`: Testing framework.
