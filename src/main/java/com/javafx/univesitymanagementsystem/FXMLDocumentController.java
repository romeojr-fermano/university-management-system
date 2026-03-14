package com.javafx.univesitymanagementsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class FXMLDocumentController implements Initializable {

  @FXML public AnchorPane login_form;
  @FXML private TextField login_username;
  @FXML private PasswordField login_password;
  @FXML private Button login_button;
  @FXML private ComboBox<String> login_role;
  @FXML public AnchorPane admin_register_form;
  @FXML private TextField admin_username;
  @FXML private PasswordField admin_password;
  @FXML private PasswordField admin_confirm_password;
  @FXML private Button admin_signup_button;
  @FXML private Hyperlink admin_sign_in;
  @FXML public AnchorPane student_signup_form;
  @FXML private TextField student_email_address;
  @FXML private TextField student_username;
  @FXML private PasswordField student_password;
  @FXML private PasswordField student_confirm_password;
  @FXML private Button student_signup_button;
  @FXML private Hyperlink student_sign_in;
  @FXML public AnchorPane teacher_signup_form;
  @FXML private TextField teacher_email_address;
  @FXML private TextField teacher_username;
  @FXML private PasswordField teacher_password;
  @FXML private PasswordField teacher_confirm_password;
  @FXML private Button teacher_signup_button;
  @FXML private Hyperlink teacher_sign_in;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    roleList();
  }

  public void switchSignupForm() {
    switch (login_role.getSelectionModel().getSelectedItem()) {
      case "Admin" -> switchVisible(false, true, false, false);
      case "Teacher" -> switchVisible(false, false, true, false);
      case "Student" -> switchVisible(false, false, false, true);
    }
  }

  public void signIn() {
    switchVisible(true, false, false, false);
  }

  private void roleList() {
    List<String> roles = new ArrayList<>(Stream.of(Role.values()).map(Role::getRoleName).toList());
    ObservableList<String> observableList = FXCollections.observableArrayList(roles);
    login_role.setItems(observableList);
  }

  private void switchVisible(
      boolean isSignIn, boolean isAdmin, boolean isTeacher, boolean isStudent) {
    login_form.setVisible(isSignIn);
    admin_register_form.setVisible(isAdmin);
    teacher_signup_form.setVisible(isTeacher);
    student_signup_form.setVisible(isStudent);
  }
}
