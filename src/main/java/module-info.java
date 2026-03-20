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
  opens com.javafx.univesitymanagementsystem.controller to
      javafx.fxml;
  opens com.javafx.univesitymanagementsystem.model to
      javafx.fxml;

  exports com.javafx.univesitymanagementsystem;
  exports com.javafx.univesitymanagementsystem.controller;
  exports com.javafx.univesitymanagementsystem.model;
  exports com.javafx.univesitymanagementsystem.service;
}
