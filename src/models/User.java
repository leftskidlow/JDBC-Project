package models;

import java.util.UUID;

public class User {

  private UUID id;
  private String username;
  private String password;

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
