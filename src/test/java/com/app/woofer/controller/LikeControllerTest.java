package com.app.woofer.controller;

import com.app.woofer.model.Likes;
import com.app.woofer.service.LikeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class LikeControllerTest {

    private LikeService mockService;
    private LikeController testSubject;

    @BeforeEach
    void setUp() {
        mockService = mock(LikeService.class);
        testSubject = new LikeController(mockService);
    }

    @Test
    void likePostTest() {
        when(mockService.likePost(1,2)).thenReturn(1);
        ResponseEntity<Integer> output = testSubject.likePost(1,2);
        Assertions.assertEquals(1,output.getBody());
    }
    @Test
    void likedPostsTest() {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        when(mockService.likedPosts(1)).thenReturn(result);
        ResponseEntity<List<Integer>> output = testSubject.getLikedPosts(1);
        Assertions.assertEquals(result,output.getBody());
    }
    @Test
    void unlikePostTest() {
        ResponseEntity<Integer> ok = ResponseEntity.ok(1);
        when(mockService.unLikePost(1,1)).thenReturn(1);
        ResponseEntity<Integer> result = testSubject.unLikePost(1,1);
        Assertions.assertEquals(ok,result);
    }
}
