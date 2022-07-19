package services;

import models.User;

import java.sql.*;
import java.util.UUID;

public class UserService {

  public static void createUser(User user, String table) {
    // TODO: Saves a User into the USERS table
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement()
    ) {
      statement.executeUpdate("INSERT INTO " + table + " VALUES (\"" +
        user.getId().toString() + "\", \"" +
        user.getUsername() + "\", \"" +
        user.getPassword() +
        "\");");
    } catch (SQLException e) {
      System.out.println("Something went wrong when saving your account to the database.");
      System.out.println(e);
    }
  }

  public static User getUserByUsername(String username) {
    // TODO: Searches the database for the user, by username
    //  returns the User or Null
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery("SELECT * FROM USERS WHERE USERNAME=\"" + username + "\";")
    ) {
      return new User(UUID.fromString(results.getString(1)), results.getString(2), results.getString(3));
    } catch (SQLException e) {
      return null;
    }
  }

  public static User getUserByID(String id) {
    // TODO: Searches the database for the user, by username
    //  returns the User or Null
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery("SELECT * FROM USERS WHERE ID=\"" + id + "\";")
    ) {
      return new User(UUID.fromString(results.getString(1)), results.getString(2), results.getString(3));
    } catch (SQLException e) {
      return null;
    }
  }

  public static User getLoggedInUser() {

    String loadFromCurrentUserTable = "SELECT * FROM " + DatabaseInfo.Tables.CURRENT_USER.label + ";";
    User user = null;
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(loadFromCurrentUserTable)
    ) {
      if (results != null) {
        user = new User(UUID.fromString(results.getString(1)), results.getString(2), results.getString(3));
        int size = 0;
        while (results.next()) {
          size++;
        }
        if (size > 1) {
          user = null;
        }
      }
    } catch (SQLException e) {
      return null;
    }
    return user;
  }

  public static void deleteUser(User user) {
    String deleteFromUsersTable = "DELETE FROM " + DatabaseInfo.Tables.USERS.label + " WHERE ID = \"" + user.getId().toString() + "\";";
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
    ) {
      statement.executeUpdate(deleteFromUsersTable);
    } catch (SQLException e) {
      System.out.println("Something went wrong clearing the current user information");
    }
  }
}
