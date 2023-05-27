package site.model;

import java.util.Objects;

public class Comment {
    private Long comment_id;
    private Long post_id;
    private String author;
    private String content;

    public Comment(Long comment_id, Long post_id, String author, String content) {
        this.comment_id = comment_id;
        this.post_id = post_id;
        this.author = author;
        this.content = content;
    }

    public Comment(Long post_id, String author, String content) {
        this.post_id = post_id;
        this.author = author;
        this.content = content;
    }

    public Long getCommentId() {
        return comment_id;
    }

    public void setCommentId(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getPostId() {
        return post_id;
    }

    public void setPostId(Long post_id) {
        this.post_id = post_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, post_id, author, content);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Comment other = (Comment) obj;
        return Objects.equals(comment_id, other.comment_id)
                && Objects.equals(post_id, other.post_id)
                && Objects.equals(author, other.author)
                && Objects.equals(content, other.content);
    }
}
