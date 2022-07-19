package services;

import java.text.SimpleDateFormat;

public class DatabaseInfo {

  public static final String DB_URL = "jdbc:sqlite:./src/resources/COMMUNITY_NEWS.db";

  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");

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
