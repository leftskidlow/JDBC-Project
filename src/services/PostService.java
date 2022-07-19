package services;

import models.Comment;
import models.Post;
import models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostService {
  // TODO: boolean savePost(Post post) {}
  // TODO: List<Post> getUsersPosts(User user) {}
  // TODO: List<Post> getPostsByUser(User user) {}

  public static Post getPostByTitle(String title) {
    String findPostbyId = "SELECT * FROM " + DatabaseInfo.Tables.POSTS + " WHERE TITLE = \"" + title + "\";";
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(findPostbyId);
      ) {
      if (results.next()) {
        User user = UserService.getUserByID(results.getString(4));
        Post post = new Post(results.getString(1), results.getString(2), results.getString(3), user, results.getLong(5), PostService.getCommentsForPost(results.getString(1)));
        post.getComments().forEach(c -> c.setPost(post));
        return post;
      }
    } catch (SQLException e) {

    }

    return null;
  }

  public static List<Post> mostRecentNews() {
    List<Post> recentStories = new ArrayList<>();
    String recentNews = "SELECT * FROM " + DatabaseInfo.Tables.POSTS + " ORDER BY POST_DATE DESC LIMIT 5;";
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(recentNews);
      ) {
          while (results.next()) {
            User user = UserService.getUserByID(results.getString(4));
            Post post = new Post(results.getString(1), results.getString(2), results.getString(3), user, results.getLong(5), PostService.getCommentsForPost(results.getString(1)));
            post.getComments().forEach(c -> c.setPost(post));
            recentStories.add(post);
      }
    } catch (SQLException e) {

    }

    return recentStories;
  }

  public static Post getMostRecentPostByUser(User user) {
    String getMostRecentPost = "SELECT * FROM " + DatabaseInfo.Tables.POSTS.label + " WHERE USER_ID = \"" + user.getId().toString() + "\" ORDER BY POST_DATE DESC;";
    Post post = null;
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(getMostRecentPost);
      ) {
      if (results != null) {
        return new Post(results.getString(1), results.getString(2), results.getString(3), user, results.getLong(5), null);
      }
    } catch (SQLException e) {

    }
    return null;
  }

  public static void saveComment(Comment comment) {
    System.out.println(comment.getDate().getTime());
    String saveComment = "INSERT INTO " + DatabaseInfo.Tables.COMMENTS + " VALUES (" +
      "\"" + comment.getPost().getId().toString() + "\", " +
      "\"" + comment.getUser().getId().toString() + "\", " +
      comment.getDate().getTime() + ", " +
      "\"" + comment.getComment() +
      "\");";
    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ) {
      statement.executeUpdate(saveComment);
    } catch (SQLException e) {

    }
  }

  private static List<Comment> getCommentsForPost(String postID) {
    List<Comment> comments = new ArrayList<>();
    String getComments = "SELECT * FROM COMMENTS WHERE POST_ID = \"" + postID + "\";";

    try (
      Connection connection = DriverManager.getConnection(DatabaseInfo.DB_URL);
      Statement statement = connection.createStatement();
      ResultSet results = statement.executeQuery(getComments);
      ) {
      while (results.next()) {
        Comment comment = new Comment(UserService.getUserByID(results.getString(2)), results.getLong(3), results.getString(4));
        comments.add(comment);
      }
    } catch (SQLException e) {

    }

    return comments;
  }
}
