package com.javafx.univesitymanagementsystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UniversityManagementSystem extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(UniversityManagementSystem.class.getResource("FXMLDocument.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("University Management System");
    stage.setScene(scene);
    stage.show();
  }
}
