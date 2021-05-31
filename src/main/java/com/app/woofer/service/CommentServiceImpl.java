package com.app.woofer.service;

import com.app.woofer.model.Comment;
import com.app.woofer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class CommentServiceImpl implements  CommentService{

    private final CommentRepository commentRepository;
    private final UserService userService;
    private static final Logger logger = LogManager.getLogger(CommentServiceImpl.class);

    @Autowired
    CommentServiceImpl(CommentRepository commentRepository, UserService userService){
        this.commentRepository = commentRepository;
        this.userService = userService;
    }
    @Override
    public Comment addComment(Comment comment) {
        logger.info("Comment added with { ID: {} }", comment.getId());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        logger.info("Comment deleted with { ID: {} }", comment.getId());
        commentRepository.deleteById(comment.getId());
    }

    @Override
    public List<Comment> getCommentByUser(int id) {
        logger.info("Comments retrieved for user with { ID: {} }", id);
        return commentRepository.findByPost_User_Id(id);
    }

    @Override
    public List<Comment> getCommentByPost(int id) {
        logger.info("Comments retrieved for post with { ID: {} }", id);
        return commentRepository.findByPost_Id(id);
    }

    @Override
    public List<Comment> getAllComments() {
        logger.info("All comments retrieved");
        return commentRepository.findAll();
    }
}
