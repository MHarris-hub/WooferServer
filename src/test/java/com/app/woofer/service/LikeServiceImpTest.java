package com.app.woofer.service;

import com.app.woofer.model.Post;
import com.app.woofer.model.User;
import com.app.woofer.repository.LikesRepository;
import com.app.woofer.repository.PostRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class LikeServiceImpTest {

    private PostRepository mockPost;
    private LikesRepository mockLikes;
    private LikeServiceImp testSubject;

    @BeforeEach
    void setUp() {
        mockLikes = mock(LikesRepository.class);
        mockPost = mock(PostRepository.class);
        testSubject = new LikeServiceImp(mockPost, mockLikes);
    }

    @Test
    void gracefullyExitOnNoPost() {
        when(mockPost.findById(anyInt())).thenReturn(Optional.empty());
        int ret = testSubject.likePost(1,1);
        Assertions.assertEquals(-1,ret);
        verify(mockLikes, never()).save(any());
    }

    @Test
    void dosentLikeWhenUserFound() {
        Post post = new Post();
        post.setLikers(new ArrayList<>());
        post.getLikers().add(new User());
        post.getLikers().get(0).setId(1);
        when(mockPost.findById(anyInt())).thenReturn(Optional.of(post));
        int ret = testSubject.likePost(1,1);
        Assertions.assertEquals(1,ret);
        verify(mockLikes, never()).save(any());
    }

    @Test
    void likes() {
        Post post = new Post();
        post.setLikers(new ArrayList<>());
        when(mockPost.findById(anyInt())).thenReturn(Optional.of(post));
        int ret = testSubject.likePost(1,1);
        Assertions.assertEquals(1,ret);
        verify(mockLikes).save(any());
    }
}
