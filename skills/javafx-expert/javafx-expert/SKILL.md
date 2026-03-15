---
name: javafx-expert
description: Expert guidance on JavaFX development including FXML structure, controller logic, CSS styling, and Scene Graph manipulation. Use when creating, refactoring, or debugging JavaFX UIs; writing or reviewing FXML/controller/CSS; troubleshooting layout, event, or resource-loading issues; or integrating JavaFX UI libraries (for example Ikonli).
---

# JavaFX Expert Skill

Use this skill to design, implement, and debug JavaFX UIs with practical best practices.

## Workflow

### 1. FXML Development
- Prefer responsive layouts (`VBox`, `HBox`, `GridPane`) over fixed positioning (`AnchorPane`).
- Always set the controller class using `fx:controller`.
- Use `fx:id` to inject elements into the controller.
- Read `references/fxml_best_practices.md` for structure and syntax rules.

### 2. Controller Logic
- Annotate injected fields and methods with `@FXML`.
- Implement `Initializable` when setup logic is needed after FXML loading.
- Keep business logic separate from UI logic; delegate complex operations to service classes.

### 3. CSS Styling
- Use `.root` to set global variables or default fonts.
- Remember the `-fx-` prefix for properties.
- Use `styleClass` for reusable styles across multiple nodes.
- Read `references/css_guide.md` for property names and selector usage.

### 4. Troubleshooting
- Window sizing: If the window is too small, check `Scene` initialization in the main class. Remove hardcoded dimensions to respect `prefWidth`/`prefHeight` from FXML.
- Missing controller: Ensure `fx:controller` matches the fully qualified class name.
- CSS not loading: Check the path in `stylesheets="@path/to/file.css"`. It is relative to the FXML file.

## Common Tasks

### Adding an Icon (Ikonli)
```xml
<FontIcon iconLiteral="fa-user" iconSize="20" iconColor="#333333"/>
```

### Creating a Responsive Form
Use a `GridPane` within a `VBox`:
```xml
<VBox spacing="20" alignment="CENTER" xmlns:fx="http://javafx.com/fxml">
    <Label text="Login" styleClass="header"/>
    <GridPane hgap="10" vgap="10">
        <!-- Form fields -->
    </GridPane>
</VBox>
```
