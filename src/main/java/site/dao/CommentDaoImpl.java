package site.dao;

import site.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.utils.JDBCUtils;
/*
 * insert into data
 * retrive form data
 * 
 */

public class CommentDaoImpl implements CommentDao {

    private static final String INSERT_COMMENT_SQL = "INSERT INTO comments (post_id, author, content) VALUES (?, ?, ?)";
    private static final String UPDATE_COMMENT_SQL = "UPDATE comments SET author = ?, content = ? WHERE comment_id = ?";
    private static final String DELETE_COMMENT_SQL = "DELETE FROM comments WHERE comment_id = ?";
    private static final String SELECT_COMMENT_BY_ID = "SELECT * FROM comments WHERE post_id = ?";
    private static final String SELECT_COMMENTS_FOR_POST_SQL = "SELECT * FROM comments WHERE post_id = ?";
    private static final String SELECT_ALL_COMMENTS = "SELECT * FROM comments";

    @Override
    public void insertComment(Comment comment) {
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT_SQL)) {
            preparedStatement.setLong(1, comment.getPostId());
            preparedStatement.setString(2, comment.getAuthor());
            preparedStatement.setString(3, comment.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
    }

    @Override
    public Comment selectComment(long commentId) {
        Comment comment = null;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_ID)) {
            preparedStatement.setLong(1, commentId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                long id = rs.getLong("comment_id");
                long postId = rs.getLong("post_id");
                String author = rs.getString("author");
                String content = rs.getString("content");
                comment = new Comment(id, postId, author, content);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return comment;
    }

    @Override
    public List<Comment> selectCommentsByPost(long postId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENTS_FOR_POST_SQL)) {
            preparedStatement.setLong(1, postId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("comment_id");
                long post_id = rs.getLong("post_id");
                String author = rs.getString("author");
                String content = rs.getString("content");
                Comment comment = new Comment(id, post_id, author, content);
                comments.add(comment);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return comments;
    }

    @Override
    public List<Comment> selectAllComments() {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("comment_id");
                long postId = rs.getLong("post_id");
                String author = rs.getString("author");
                String content = rs.getString("content");
                Comment comment = new Comment(id, postId, author, content);
                comments.add(comment);
            }
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return comments;
    }

    @Override
    public boolean deleteComment(long postId) {
        boolean rowDeleted = false;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_COMMENT_SQL);) {
            statement.setLong(1, postId);

            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateComment(Comment comment) {
        boolean rowUpdated = false;
        try (Connection connection = JDBCUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_COMMENT_SQL)) {
            statement.setString(1, comment.getAuthor());
            statement.setString(2, comment.getContent());
            statement.setLong(3, comment.getCommentId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException exception) {
            JDBCUtils.printSQLException(exception);
        }
        return rowUpdated;
    }
}
