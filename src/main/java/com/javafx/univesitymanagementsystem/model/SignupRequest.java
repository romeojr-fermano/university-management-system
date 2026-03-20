package com.javafx.univesitymanagementsystem.model;

import com.javafx.univesitymanagementsystem.user.Role;

public record SignupRequest(
    String username, String email, String password, String confirmPassword, Role role) {}
