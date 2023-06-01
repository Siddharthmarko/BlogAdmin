package site.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import site.web.LoginController;
import site.model.BlogPost;
import site.utils.JDBCUtils;

public class BlogPostDaoImpl implements BlogPostDao {

    private static final String INSERT_BLOG_POST_SQL = "INSERT INTO blog_posts (title, content, author, category, user) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BLOG_POST_BY_ID = "SELECT * FROM blog_posts WHERE id = ?";
    private static final String SELECT_ALL_BLOG_POSTS = "SELECT * FROM blog_posts WHERE user = "
            + LoginController.usekaro + "";
    private static final String DELETE_BLOG_POST_BY_ID = "DELETE FROM blog_posts WHERE id = ?";
    private static final String DELETE_BLOG_COMMENT_BY_ID = "DELETE FROM comments WHERE post_id = ?";
    private static final String UPDATE_BLOG_POST = "UPDATE blog_posts SET title = ?, content = ?, author = ?, category = ? WHERE id = ?";

    @Override
    public void insertBlogPost(BlogPost blogPost) {

        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BLOG_POST_SQL)) {
            System.out.println("inserting");
            System.out.println(blogPost.getUser());
            preparedStatement.setString(1, blogPost.getTitle());
            preparedStatement.setString(2, blogPost.getContent());
            preparedStatement.setString(3, blogPost.getAuthor());
            preparedStatement.setString(4, blogPost.getCategory());
            preparedStatement.setString(5, LoginController.usekaro);
            System.out.println(LoginController.usekaro);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public BlogPost selectBlogPost(long postId) {
        BlogPost blogPost = null;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BLOG_POST_BY_ID)) {
            preparedStatement.setLong(1, postId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String user = LoginController.usekaro;
                String author = rs.getString("author");
                String category = rs.getString("category");
                blogPost = new BlogPost(id, title, content, user, author, category);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return blogPost;
    }

    @Override
    public List<BlogPost> selectAllBlogPosts() {
        // using try-with-resources to avoid closing resources (boilerplate code)
        List<BlogPost> blogPosts = new ArrayList<>();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
                // Step 2: Create a statement using the connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BLOG_POSTS);) {
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String user = rs.getString("user");
                String author = rs.getString("author");
                String category = rs.getString("category");

                blogPosts.add(new BlogPost(id, title, content, user, author, category));
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return blogPosts;
    }

    @Override
    public boolean deleteBlogPost(long postId) {
        boolean rowDeleted = false;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_POST_BY_ID);
                PreparedStatement statement2 = connection.prepareStatement(DELETE_BLOG_COMMENT_BY_ID);) {
            statement.setLong(1, postId);
            statement2.setLong(1, postId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBlogPost(BlogPost blogPost) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG_POST);) {
            statement.setString(1, blogPost.getTitle());
            statement.setString(2, blogPost.getContent());
            statement.setString(3, blogPost.getAuthor());
            statement.setString(4, blogPost.getCategory());
            statement.setLong(5, blogPost.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
            throw e;
        }
        return rowUpdated;
    }


}
