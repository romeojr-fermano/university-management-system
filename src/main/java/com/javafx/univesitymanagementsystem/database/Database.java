package com.javafx.univesitymanagementsystem.database;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class Database {
  private static final String DB_NAME = "university_management.sqlite";

  public static Connection connect() throws SQLException {
    String dbPath = Paths.get(System.getProperty("user.dir"), DB_NAME).toString();
    return DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbPath));
  }
}
