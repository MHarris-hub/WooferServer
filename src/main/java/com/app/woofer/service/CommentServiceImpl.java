package com.app.woofer.service;

import com.app.woofer.model.Comment;
import com.app.woofer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements  CommentService{

    private final CommentRepository commentRepository;
    private final UserService userService;
    @Autowired
    CommentServiceImpl(CommentRepository commentRepository, UserService userService){
        this.commentRepository = commentRepository;
        this.userService = userService;
    }
    @Override
    public Comment addComment(Comment comment) {

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) { commentRepository.deleteById(comment.getId());}

    @Override
    public List<Comment> getCommentByUser(int id) { return commentRepository.findByPost_User_Id(id);}

    @Override
    public List<Comment> getCommentByPost(int id) {
        return commentRepository.findByPost_Id(id);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }


}
