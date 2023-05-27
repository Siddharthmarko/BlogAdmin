package site.model;

import java.io.Serializable;
import java.util.Objects;

public class BlogPost implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String content;
    private String user;
    private String author;
    private String category;

    public BlogPost(long id, String title, String content, String user, String author, String category) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.author = author;
        this.category = category;
    }

    public BlogPost(String title, String content, String user, String author, String category) {
        super();
        this.title = title;
        this.content = content;
        this.author = author;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BlogPost other = (BlogPost) obj;
        return id == other.id;
    }
}
