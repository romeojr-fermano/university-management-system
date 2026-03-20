package com.javafx.univesitymanagementsystem.service;

import com.javafx.univesitymanagementsystem.model.SignupRequest;
import com.javafx.univesitymanagementsystem.model.SignupResult;
import com.javafx.univesitymanagementsystem.repository.UserRepository;
import java.sql.SQLException;
import org.apache.commons.validator.routines.EmailValidator;

public class AuthService {

  private static final int MIN_PASSWORD_LENGTH = 8;
  private static final int MAX_PASSWORD_LENGTH = 72;
  private static final int MIN_USERNAME_LENGTH = 3;
  private static final int MAX_USERNAME_LENGTH = 50;

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

    if (request.username().length() < MIN_USERNAME_LENGTH
        || request.username().length() > MAX_USERNAME_LENGTH) {
      return "Username must be between 3 and 50 characters";
    }

    if (request.password() == null || request.password().isEmpty()) {
      return "Password is required";
    }

    if (request.password().length() < MIN_PASSWORD_LENGTH) {
      return "Password must be at least " + MIN_PASSWORD_LENGTH + " characters";
    }

    if (request.password().length() > MAX_PASSWORD_LENGTH) {
      return "Password must not exceed 72 characters";
    }

    if (!request.password().equals(request.confirmPassword())) {
      return "Passwords don't match";
    }

    if (!request.email().isEmpty() && !EmailValidator.getInstance().isValid(request.email())) {
      return "Invalid email format";
    }

    return null;
  }
}
