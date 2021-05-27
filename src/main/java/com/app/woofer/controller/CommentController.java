package com.app.woofer.controller;

import com.app.woofer.model.Comment;
import com.app.woofer.model.User;
import com.app.woofer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final User user;

    @Autowired
    public CommentController(CommentService commentService, User user){
        this.commentService = commentService;
        this.user = user;
    }

    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment){return commentService.addComment(comment);}

    @GetMapping("/comment/user/{id}")
    public List<Comment> getCommentByUser(@PathVariable int id){
        return commentService.getCommentByUser(id);
    }
    @GetMapping("/comment/post/{id}")
    public List<Comment> getCommentByPost(@PathVariable int id){
        return commentService.getCommentByPost(id);
    }

}
