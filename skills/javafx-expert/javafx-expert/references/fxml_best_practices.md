# JavaFX FXML Best Practices

## Structure & Layout
- **Root Element**: Every FXML file must have a single root element (e.g., `AnchorPane`, `VBox`, `StackPane`).
- **Namespaces**: Always include `xmlns="http://javafx.com/javafx/..."` and `xmlns:fx="http://javafx.com/fxml/1"`.
- **Imports**: Import only necessary classes (`<?import javafx.scene.control.*?>`). Wildcards are acceptable for standard packages.

## Linking to Code
- **Controller**: Use the `fx:controller` attribute on the root element to link a Java controller class.
  ```xml
  <VBox fx:controller="com.example.MyController" ...>
  ```
- **IDs**: Use `fx:id` to inject UI elements into the controller. The field name in the controller must match the `fx:id` exactly.
  ```java
  @FXML private Button submitButton; // Matches fx:id="submitButton"
  ```
- **Event Handlers**: Use `onAction="#methodName"` for button clicks and other primary actions. The method must be annotated with `@FXML` in the controller.

## Layout Panes
- **Responsive Design**: Avoid absolute positioning (`AnchorPane` with fixed coordinates) for scalable UIs. Use:
  - `VBox`/`HBox`: Linear stacking.
  - `GridPane`: Form layouts.
  - `BorderPane`: Standard application layout (Top, Left, Center, Right, Bottom).
  - `StackPane`: Overlaying elements (e.g., loading spinner on top of content).

## Ikonli Icons
- Import `org.kordamp.ikonli.javafx.FontIcon`.
- Use `iconLiteral` to specify the icon code (e.g., `fa-user`).
- Example:
  ```xml
  <FontIcon iconLiteral="fa-user" iconSize="24" iconColor="white"/>
  ```
