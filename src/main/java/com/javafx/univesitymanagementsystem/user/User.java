package com.javafx.univesitymanagementsystem.user;

import com.javafx.univesitymanagementsystem.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  Long id;
  String username;
  String password;
  String emailAddress;
  Role role;
}
