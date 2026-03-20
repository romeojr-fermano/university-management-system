package com.javafx.univesitymanagementsystem.user;

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
