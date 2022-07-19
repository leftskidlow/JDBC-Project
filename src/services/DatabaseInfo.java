package services;

public class DatabaseInfo {

  public static final String DB_URL = "jdbc:sqlite:./src/resources/COMMUNITY_NEWS.db";

  public enum Tables {
    USERS ("USERS"),
    CURRENT_USER ("CURRENT_USER"),
    POSTS ("POSTS"),
    COMMENTS ("COMMENTS");

    public final String label;

    Tables(String label) {
      this.label = label;
    }
  }
}
