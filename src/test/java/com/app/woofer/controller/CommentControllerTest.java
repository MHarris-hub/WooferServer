package com.app.woofer.controller;

import com.app.woofer.model.Comment;
import com.app.woofer.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommentControllerTest {

    private CommentService commentService;
    private CommentController commentController;

    @BeforeEach
    void setUp() {
        commentService = mock(CommentService.class);
        commentController = new CommentController(commentService);
    }

    @Test
    void addCommentTest(){
        Comment comment = new Comment();
        comment.setBody("s");
        comment.setId(1);
        ResponseEntity<Comment> ok = ResponseEntity.ok(comment);
        when(commentService.addComment(any())).thenReturn(comment);
        Assertions.assertTrue(commentController.addComment(comment).equals(ok));
    }
    @Test
    void getByUserTest(){
        Comment comment = new Comment();
        comment.setBody("s");
        comment.setId(1);
        ResponseEntity<Comment> ok = ResponseEntity.ok(comment);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        when(commentService.getCommentByUser(anyInt())).thenReturn(null);
        Assertions.assertFalse(commentController.getCommentByUser(1).equals(ok));
    }
    @Test
    void getByPostTest(){
        Comment comment = new Comment();
        comment.setBody("s");
        comment.setId(1);
        ResponseEntity<Comment> ok = ResponseEntity.ok(comment);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        when(commentService.getCommentByPost(anyInt())).thenReturn(commentList);
        Assertions.assertFalse(commentController.getCommentByPost(1).equals(ok));
    }
    @Test
    void getAllComments(){
        Comment comment = new Comment();
        comment.setBody("s");
        comment.setId(1);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        ResponseEntity<Comment> ok = ResponseEntity.ok(comment);
        when(commentService.getAllComments()).thenReturn(commentList);
        Assertions.assertFalse(commentController.getAllComments().equals(ok));
    }
}
