package edu.shadsluiter.comments.model;

import java.time.LocalDateTime;
 

public class AppComment {
    private int id;
    private String author;
    private String content; 

    public AppComment(int id, String author, String content ) {
        this.id = id;
        this.author = author;
        this.content = content; 
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
 
    

    @Override

    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' + 
                '}';
    }
    
}
