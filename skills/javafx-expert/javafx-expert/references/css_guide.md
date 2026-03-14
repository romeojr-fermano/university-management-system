# JavaFX CSS Guide

## JavaFX vs Web CSS
- JavaFX CSS properties generally start with `-fx-`.
- Example: `background-color` becomes `-fx-background-color`.
- Standard CSS syntax applies (selectors, braces, semicolons).

## Selectors
- **Type Selector**: Target all instances of a class.
  ```css
  .button { ... }
  .label { ... }
  ```
- **ID Selector**: Target a specific node by its `id` (not `fx:id`).
  ```css
  #submit-btn { ... }
  ```
- **Class Selector**: Target nodes with a specific style class.
  ```css
  .warning-text { ... }
  ```
  Add the class in FXML: `styleClass="warning-text"`.

## Common Properties
- **Background**: `-fx-background-color`, `-fx-background-radius`, `-fx-background-insets`.
  - Gradients: `linear-gradient(to bottom, #color1, #color2)`
- **Text**: `-fx-text-fill` (color), `-fx-font-family`, `-fx-font-size`, `-fx-font-weight`.
- **Borders**: `-fx-border-color`, `-fx-border-width`, `-fx-border-radius`.
- **Padding/Spacing**: `-fx-padding`, `-fx-spacing` (for VBox/HBox).

## Pseudo-classes
- **State-based styling**:
  - `.button:hover`: Mouse over.
  - `.button:pressed`: Clicked.
  - `.text-field:focused`: Element has focus.
  - `.check-box:selected`: Checked state.

## Loading CSS
- Attach the stylesheet to the root element in FXML:
  ```xml
  <VBox stylesheets="@styles/main.css" ...>
  ```
- Or in Java code:
  ```java
  scene.getStylesheets().add(getClass().getResource("styles/main.css").toExternalForm());
  ```
