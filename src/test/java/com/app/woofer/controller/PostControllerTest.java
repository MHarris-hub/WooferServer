package com.app.woofer.controller;

import com.app.woofer.model.Post;
import com.app.woofer.model.User;
import com.app.woofer.model.ret.ReturnPost;
import com.app.woofer.service.PostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PostControllerTest {

    private PostService mockPostService;
    private PostController testSubject;

    Post generatePost(int seed) {return new Post(seed, new User(seed, seed+"", seed+"", seed+"", seed+"", seed+"", seed+""), null, seed, seed+"");}

    @BeforeEach
    void setUp() {
        mockPostService = mock(PostService.class);
        testSubject = new PostController(mockPostService);
    }

    @Test
    void addPostTest() {
        when(mockPostService.addPost(any())).thenReturn(generatePost(1));
        ReturnPost output = testSubject.addPost(new ReturnPost(generatePost(1))).getBody();
        Assertions.assertEquals(output.getId(),1);
        Assertions.assertEquals(output.getBody(),"1");
    }

    @Test
    void putPostTest() {
        when(mockPostService.putPost(any())).thenReturn(generatePost(2));
        when(mockPostService.getPost(1)).thenReturn(generatePost(1));
        ReturnPost output = testSubject.putPost(new ReturnPost(generatePost(1))).getBody();
        Assertions.assertEquals(output.getUserId(),2);
        Assertions.assertEquals(output.getBody(),"2");
    }

    @Test
    void remPostTest() {
        testSubject.remPost(1);
        verify(mockPostService).remPost(1);
    }

    @Test
    void getPostTest() {
        when(mockPostService.getPost(anyInt())).thenReturn(generatePost(1));
        ReturnPost output = testSubject.getPost(1).getBody();
        Assertions.assertEquals(output.getId(),1);
        Assertions.assertEquals(output.getBody(),"1");
    }

    @Test
    void getPostsByUserTest() {
        List<Post> ret = new ArrayList<>();
        ret.add(generatePost(1));
        when(mockPostService.getByUserID(anyInt())).thenReturn(ret);
        List<ReturnPost> output = testSubject.getPostsByUser(1).getBody();
        Assertions.assertEquals(output.get(0).getId(),1);
        Assertions.assertEquals(output.get(0).getBody(),"1");
    }

    @Test
    void getAllPostsTest() {
        List<Post> ret = new ArrayList<>();
        ret.add(generatePost(1));
        when(mockPostService.getAll()).thenReturn(ret);
        List<ReturnPost> output = testSubject.getAllPosts().getBody();
        Assertions.assertEquals(output.get(0).getId(),1);
        Assertions.assertEquals(output.get(0).getBody(),"1");
    }
}
