package com.javafx.univesitymanagementsystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
  ADMIN("Admin"),
  STUDENT("Student"),
  TEACHER("Teacher");

  private final String roleName;
}
