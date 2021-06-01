package com.app.woofer.service;

import com.app.woofer.model.Comment;
import com.app.woofer.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CommentServiceTest {

    private CommentRepository commentRepository;
    private UserService userService;
    private CommentService commentService;
    @BeforeEach
    void first(){
        commentRepository = mock(CommentRepository.class);
        userService = mock(UserService.class);
        commentService = new CommentServiceImpl(commentRepository,userService);
    }

    @Test
    void getAllCommentsTest(){
        commentService.getAllComments();
        verify(commentRepository).findAll();
    }
    @Test
    void getCommentByUserTest(){
        commentService.getCommentByUser(1);
        verify(commentRepository).findByPost_User_Id(1);
    }
    @Test
    void getCommentByPostTest(){
        commentService.getCommentByPost(1);
        verify(commentRepository).findByPost_Id(1);
    }
    @Test
    void addCommentTest(){
        Comment comment = new Comment();
        commentService.addComment(comment);
        verify(commentRepository).save(comment);
    }
    @Test
    void deleteCommentTest(){
        Comment comment = new Comment();
        commentService.deleteComment(comment);
        verify(commentRepository).deleteById(any());
    }
}
