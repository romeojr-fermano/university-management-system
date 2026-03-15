module com.javafx.univesitymanagementsystem {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  requires org.xerial.sqlitejdbc;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.ikonli.core;
  requires org.kordamp.ikonli.fontawesome;
  requires static lombok;

  opens com.javafx.univesitymanagementsystem to
      javafx.fxml;

  exports com.javafx.univesitymanagementsystem;
}
