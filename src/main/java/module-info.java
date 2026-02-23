module com.javafx.univesitymanagementsystem {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.javafx.univesitymanagementsystem to
      javafx.fxml;

  exports com.javafx.univesitymanagementsystem;
}
