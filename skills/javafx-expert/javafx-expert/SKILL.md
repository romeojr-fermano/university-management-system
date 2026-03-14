---
name: javafx-expert
description: Expert guidance on JavaFX development, including FXML structure, Controller logic, CSS styling, and Scene Graph manipulation. Use when creating or debugging JavaFX UIs.
---

# JavaFX Expert Skill

This skill provides expert knowledge for developing JavaFX applications. It covers best practices for FXML layouts, Controller implementation, CSS styling, and common troubleshooting steps.

## When to Use
- **Creating new UI screens**: Designing FXML layouts and corresponding controllers.
- **Styling components**: Writing CSS for JavaFX applications.
- **Debugging UI issues**: Layouts not resizing, elements missing, or events not firing.
- ** integrating libraries**: Using Ikonli for icons or other JavaFX libraries.

## Workflow

### 1. FXML Development
When working with FXML files:
- Use **responsive layouts** (`VBox`, `HBox`, `GridPane`) instead of fixed positioning (`AnchorPane`) whenever possible.
- Always set the **controller class** using `fx:controller`.
- Use `fx:id` to inject elements into the controller.
- **Reference**: Read `references/fxml_best_practices.md` for detailed structure and syntax rules.

### 2. Controller Logic
- Annotate injected fields and methods with `@FXML`.
- Implement `Initializable` if you need setup logic after FXML loading.
- Keep business logic separate from UI logic; delegate complex operations to service classes.

### 3. CSS Styling
- Use `.root` to set global variables or default fonts.
- Remember the `-fx-` prefix for properties.
- Use `styleClass` for reusable styles across multiple nodes.
- **Reference**: Read `references/css_guide.md` for property names and selector usage.

### 4. Troubleshooting
- **Window Sizing**: If the window is too small, check `Scene` initialization in the main class. Remove hardcoded dimensions to respect `prefWidth`/`prefHeight` from FXML.
- **Missing Controller**: Ensure `fx:controller` matches the fully qualified class name.
- **CSS Not Loading**: Check the path in `stylesheets="@path/to/file.css"`. It is relative to the FXML file.

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
