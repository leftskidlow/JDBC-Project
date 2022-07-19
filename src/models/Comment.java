package models;

import java.util.Date;
import java.util.UUID;

public class Comment {

  private Post post;
  private User user;
  private Date date;
  private String comment;

  public Comment(String comment, User user, Post post) {
    this.post = post;
    this.user = user;
    this.date = new Date();
    this.comment = comment;
  }

  public Comment(User user, long date, String comment) {
    this.post = null;
    this.user = user;
    this.date = new Date(date);
    this.comment = comment;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public String getComment() {
    return comment;
  }

  public User getUser() {
    return user;
  }

  public Date getDate() {
    return date;
  }

  public Post getPost() {return post; }
}
