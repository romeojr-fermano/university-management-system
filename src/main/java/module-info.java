module com.javafx.univesitymanagementsystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.ikonli.core;
  requires  org.kordamp.ikonli.fontawesome;

  opens com.javafx.univesitymanagementsystem to
      javafx.fxml;

  exports com.javafx.univesitymanagementsystem;
}
