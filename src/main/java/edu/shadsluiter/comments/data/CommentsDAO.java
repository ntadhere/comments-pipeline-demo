package edu.shadsluiter.comments.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.shadsluiter.comments.model.AppComment;

public class CommentsDAO {

    private List<AppComment> comments = new ArrayList<>();
    private int nextId = 1;

    public CommentsDAO() {
        initialData();
    }

    private void initialData() {

        if (comments.size() > 0) {
            return;
        }

        AppComment comment1 = new AppComment(1, "Alice",
                "This is a great day to talk about life.",
                LocalDate.now().minusDays(2));

        AppComment comment2 = new AppComment(2, "Bob",
                "I agree with Alice!",
                LocalDate.now().minusDays(1));

        AppComment comment3 = new AppComment(3, "Charlie",
                "I feel like coding today.",
                LocalDate.now());

        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        this.nextId = 4;
    }

    public void addComment(AppComment comment) {
        comment.setId(nextId++);
        if (comment.getCreatedAt() == null) {
            comment.setCreatedAt(LocalDate.now());
        }
        comments.add(comment);
    }

    public void addComment(String author, String content) {
        AppComment newComment = new AppComment(nextId++, author, content, LocalDate.now());
        comments.add(newComment);
    }

    public List<AppComment> getComments() {
        return comments;
    }

    public void clearComments() {
        comments.clear();
        nextId = 1;
    }

    public AppComment getCommentById(int id) {
        for (AppComment comment : comments) {
            if (comment.getId() == id) {
                return comment;
            }
        }
        return null;
    }

    public void updateComment(AppComment updatedComment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == updatedComment.getId()) {
                comments.set(i, updatedComment);
                return;
            }
        }
    }

    public void deleteComment(int id) {
        comments.removeIf(comment -> comment.getId() == id);
    }

    // NEW method required by the assignment
    public List<AppComment> searchComments(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            // no search term: return all comments
            return comments;
        }

        List<AppComment> results = new ArrayList<>();
        String lower = searchTerm.toLowerCase();

        for (AppComment comment : comments) {
            if (comment.getContent().toLowerCase().contains(lower) ||
                comment.getAuthor().toLowerCase().contains(lower)) {
                results.add(comment);
            }
        }
        return results;
    }

    // (optional) keep old name but delegate
    public List<AppComment> searchForComments(String searchTerm) {
        return searchComments(searchTerm);
    }
}
