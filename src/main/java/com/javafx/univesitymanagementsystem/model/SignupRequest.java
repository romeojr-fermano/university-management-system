package com.javafx.univesitymanagementsystem.model;

public record SignupRequest(
    String username, String email, String password, String confirmPassword, String role) {}
