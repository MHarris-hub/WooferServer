package com.app.woofer.controller;

import com.app.woofer.service.LikeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}
