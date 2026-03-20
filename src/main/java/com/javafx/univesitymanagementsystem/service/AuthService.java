package com.javafx.univesitymanagementsystem.service;

import com.javafx.univesitymanagementsystem.model.SignupRequest;
import com.javafx.univesitymanagementsystem.model.SignupResult;
import com.javafx.univesitymanagementsystem.repository.UserRepository;
import java.sql.SQLException;

public class AuthService {

  private static final String EMAIL_REGEX =
      "^[\\w.!#$%&'*+/=?^`{|}~-]+@[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?(?:\\.[a-z\\d](?:[a-z\\d-]{0,61}[a-z\\d])?)*$";
  private static final int MIN_PASSWORD_LENGTH = 8;

  private final UserRepository userRepository;

  public AuthService() {
    this.userRepository = new UserRepository();
  }

  public SignupResult signup(SignupRequest request) {
    String validationError = validateSignup(request);
    if (validationError != null) {
      return new SignupResult(false, validationError);
    }

    try {
      if (userRepository.usernameExists(request.username())) {
        return new SignupResult(false, "Username already exists");
      }

      if (userRepository.emailExists(request.email())) {
        return new SignupResult(false, "Email already registered");
      }

      userRepository.insertUser(
          request.username(), request.email(), request.password(), request.role());
      return new SignupResult(true, null);
    } catch (SQLException e) {
      return new SignupResult(false, "Database error: " + e.getMessage());
    }
  }

  private String validateSignup(SignupRequest request) {
    if (request.username() == null || request.username().trim().isEmpty()) {
      return "Username is required";
    }

    if (request.username().length() < 3 || request.username().length() > 50) {
      return "Username must be between 3 and 50 characters";
    }

    if (request.password() == null || request.password().isEmpty()) {
      return "Password is required";
    }

    if (request.password().length() < MIN_PASSWORD_LENGTH) {
      return "Password must be at least " + MIN_PASSWORD_LENGTH + " characters";
    }

    if (request.password().length() > 72) {
      return "Password must not exceed 72 characters";
    }

    if (!request.password().equals(request.confirmPassword())) {
      return "Passwords don't match";
    }

    if (!request.email().isEmpty() && !request.email().matches(EMAIL_REGEX)) {
      return "Invalid email format";
    }

    return null;
  }
}
