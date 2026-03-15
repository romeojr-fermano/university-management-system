package com.javafx.univesitymanagementsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
  private static final String URL = "jdbc:sqlite:university_management.sqlite";

  private Database() {}

  public static Connection connect() throws SQLException {
    return DriverManager.getConnection(URL);
  }
}
