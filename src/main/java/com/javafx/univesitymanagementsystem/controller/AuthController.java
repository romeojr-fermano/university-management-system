package com.javafx.univesitymanagementsystem.controller;

import com.javafx.univesitymanagementsystem.user.Role;
import com.javafx.univesitymanagementsystem.model.SignupRequest;
import com.javafx.univesitymanagementsystem.service.AuthService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class AuthController implements Initializable {

  private final AuthService authService = new AuthService();

  @FXML public AnchorPane login_form;
  @FXML public AnchorPane admin_register_form;
  @FXML public AnchorPane student_signup_form;
  @FXML public AnchorPane teacher_signup_form;
  @FXML private TextField login_username;
  @FXML private PasswordField login_password;
  @FXML private Button login_button;
  @FXML private ComboBox<String> login_role;
  @FXML private TextField admin_username;
  @FXML private PasswordField admin_password;
  @FXML private PasswordField admin_confirm_password;
  @FXML private Button admin_signup_button;
  @FXML private Hyperlink admin_sign_in;
  @FXML private TextField student_email_address;
  @FXML private TextField student_username;
  @FXML private PasswordField student_password;
  @FXML private PasswordField student_confirm_password;
  @FXML private Button student_signup_button;
  @FXML private Hyperlink student_sign_in;
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

  @FXML
  public void handleSignup() {
    String role = detectRoleFromVisibleForm();
    
    if (role == null) {
      showErrorAlert("No signup form is currently visible");
      return;
    }
    
    SignupRequest request = extractFormFields(role);

    AuthService.SignupResult result = authService.signup(request);

    if (!result.success()) {
      showErrorAlert(result.errorMessage());
      return;
    }

    showSuccessAlertAndNavigate();
  }
  
  private void showSuccessAlertAndNavigate() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText("Account Created");
    alert.setContentText("Your account has been created successfully. Please sign in.");
    alert.setOnCloseRequest(event -> signIn());
    alert.show();
  }

  private String detectRoleFromVisibleForm() {
    if (admin_register_form.isVisible()) return Role.ADMIN.getRoleName();
    if (student_signup_form.isVisible()) return Role.STUDENT.getRoleName();
    if (teacher_signup_form.isVisible()) return Role.TEACHER.getRoleName();
    return null;
  }

  private SignupRequest extractFormFields(String role) {
    String username;
    String email;
    String password;
    String confirmPassword;

    switch (role) {
      case "Admin" -> {
        username = admin_username.getText();
        email = "";
        password = admin_password.getText();
        confirmPassword = admin_confirm_password.getText();
      }
      case "Student" -> {
        username = student_username.getText();
        email = student_email_address.getText();
        password = student_password.getText();
        confirmPassword = student_confirm_password.getText();
      }
      case "Teacher" -> {
        username = teacher_username.getText();
        email = teacher_email_address.getText();
        password = teacher_password.getText();
        confirmPassword = teacher_confirm_password.getText();
      }
      default -> throw new IllegalStateException("Unknown role: " + role);
    }

    return new SignupRequest(username, email, password, confirmPassword, Role.valueOf(role.toUpperCase()));
  }

  private void showSuccessAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText("Account Created");
    alert.setContentText("Your account has been created successfully. Please sign in.");
    alert.showAndWait();
  }

  private void showErrorAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
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
