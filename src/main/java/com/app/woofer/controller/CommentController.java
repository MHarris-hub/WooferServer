package com.app.woofer.controller;

import com.app.woofer.model.Comment;
import com.app.woofer.model.User;
import com.app.woofer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.addComment(comment));
    }
    @GetMapping("/comment")
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(commentService.getAllComments());
    }
    @GetMapping("/comment/user/{id}")
    public ResponseEntity<List<Comment>> getCommentByUser(@PathVariable int id){
        return ResponseEntity.ok(commentService.getCommentByUser(id));
    }
    @GetMapping("/comment/post/{id}")
    public ResponseEntity<List<Comment>> getCommentByPost(@PathVariable int id){
        return ResponseEntity.ok(commentService.getCommentByPost(id));
    }

}
