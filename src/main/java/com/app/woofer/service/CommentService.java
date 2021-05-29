package com.app.woofer.service;

import com.app.woofer.model.Comment;
import com.app.woofer.model.User;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    void deleteComment(Comment comment);
    List<Comment> getCommentByUser(int id);
    List<Comment> getCommentByPost(int id);
    List<Comment> getAllComments();
}
