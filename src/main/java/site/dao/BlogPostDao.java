package site.dao;

import java.sql.SQLException;
import java.util.List;

import site.model.BlogPost;

public interface BlogPostDao {

    void insertBlogPost(BlogPost blogPost);

    BlogPost selectBlogPost(long postId);

    List<BlogPost> selectAllBlogPosts();

    boolean deleteBlogPost(long postId);

    boolean updateBlogPost(BlogPost blogPost) throws SQLException;

}
