package com.javafx.univesitymanagementsystem.repository;

import com.javafx.univesitymanagementsystem.database.Database;
import com.javafx.univesitymanagementsystem.user.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

  public boolean usernameExists(String username) throws SQLException {
    String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, username);
      try (ResultSet rs = stmt.executeQuery()) {
        rs.next();
        return rs.getInt(1) > 0;
      }
    }
  }

  public boolean emailExists(String email) throws SQLException {
    if (email == null || email.isEmpty()) {
      return false;
    }
    String sql = "SELECT COUNT(*) FROM users WHERE email_address = ?";
    try (Connection conn = Database.connect();
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, email);
      try (ResultSet rs = stmt.executeQuery()) {
        rs.next();
        return rs.getInt(1) > 0;
      }
    }
  }

  public void insertUser(String username, String email, String password, Role role)
      throws SQLException {
    String sql = "INSERT INTO users (username, password, email_address, role) VALUES (?, ?, ?, ?)";
    try (Connection conn = Database.connect()) {
      conn.setAutoCommit(false);
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, email.isEmpty() ? null : email);
        stmt.setString(4, role.name());
        stmt.executeUpdate();
        conn.commit();
      } catch (SQLException e) {
        conn.rollback();
        throw e;
      }
    }
  }
}
