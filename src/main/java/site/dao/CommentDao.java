package site.dao;

import java.util.List;

import site.model.Comment;

public interface CommentDao {

    void insertComment(Comment comment);

    Comment selectComment(long commentId);

    List<Comment> selectCommentsByPost(long postId);

    List<Comment> selectAllComments();

    boolean deleteComment(long commentId);

    boolean updateComment(Comment comment);

}
