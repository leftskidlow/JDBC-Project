package models;

import java.util.UUID;

public class User {

  /* Instance Variables */
  private final UUID id;
  private final String username;
  private final String password;

  /* Constructors */
  public User (String username, String password) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.password = password;
  }

  public User (UUID id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  /* Getters and Setters */
  public String getUsername() {
    return username;
  }

  public UUID getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }
}
