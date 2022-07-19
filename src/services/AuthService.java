package services;

import models.User;
import viewmodels.MainThread;

import java.sql.*;

public class AuthService {

  public static void login(User user) {
    // Clear CurrentUser Table (logout)
    AuthService.logout();
    // Save into CurrentUser Table
    UserService.createUser(user, DatabaseInfo.Tables.CURRENT_USER.label);
  }

  public static User loadFromCurrentUserTable() {
    // TODO: checks if there is data in the currentUser table, if there is:
    //  return the user saved there to the main program
    return UserService.getLoggedInUser();
  }

  public static User logout() {
    // TODO: Deletes the user (and all data) from the currentUser table
    //  Returns a null reference to set the user of the forum to null
    String clearCurrentUserTable = "DELETE FROM " + DatabaseInfo.Tables.CURRENT_USER.label + ";";
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
    ) {
      statement.executeUpdate(clearCurrentUserTable);
    } catch (SQLException e) {
      System.out.println("Something went wrong clearing the current user information");
    }
    return null;
  }



}
