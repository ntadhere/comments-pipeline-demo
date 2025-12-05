package edu.shadsluiter.comments.model;
 
import java.time.LocalDate;


public class AppComment {
    private int id;
    private String author;
    private String content; 
    private LocalDate createdAt;

    public AppComment(int id, String author, String content, LocalDate createdAt) {
        this.id = id;
        this.author = author;
        this.content = content; 
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override

    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' + 
                '}';
    }
    
}
