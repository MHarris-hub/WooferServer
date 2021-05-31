package com.app.woofer.service;

import com.app.woofer.model.Post;
import com.app.woofer.model.User;
import com.app.woofer.repository.PostRepository;
import com.app.woofer.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PostServiceImplTest {

    private PostService testSubject;
    private PostRepository mockedRepo;
    private UserRepository mockedUserRepo;

    Post generatePost(int seed) {return new Post(seed, new User(seed, null, seed+"", seed+"", seed+"", null), null, null, seed, seed+"");}

    @BeforeEach
    void setUp() {
        mockedRepo = mock(PostRepository.class);
        mockedUserRepo = mock(UserRepository.class);
        testSubject = new PostServiceImpl(mockedRepo, mockedUserRepo);
    }

    @Test
    void addPostTest() {
        when(mockedRepo.save(any())).thenReturn(generatePost(1));
        when(mockedUserRepo.findById(1)).thenReturn(Optional.of(generatePost(1).getUser()));
        Post ret = testSubject.addPost(generatePost(1));
        Assertions.assertEquals("1",ret.getBody());
        Assertions.assertEquals(1,ret.getId());
        Assertions.assertEquals(1,ret.getUserID());
    }

    @Test
    void putPostTest() {
        when(mockedRepo.save(any())).thenReturn(generatePost(1));
        Post ret = testSubject.putPost(generatePost(1));
        Assertions.assertEquals("1",ret.getBody());
        Assertions.assertEquals(1,ret.getId());
        Assertions.assertEquals(1,ret.getUserID());
    }

    @Test
    void remPostTest() {
        testSubject.remPost(generatePost(1));
        verify(mockedRepo).delete(any(Post.class));
    }

    @Test
    void remPostIdTest() {
        testSubject.remPost(1);
        verify(mockedRepo).deleteById(1);
    }

    @Test
    void getPostTest() {
        when(mockedRepo.findById(1)).thenReturn(Optional.of(generatePost(1)));
        Post ret = testSubject.getPost(1);
        Assertions.assertEquals("1",ret.getBody());
        Assertions.assertEquals(1,ret.getId());
        Assertions.assertEquals(1,ret.getUserID());
    }

    @Test
    void getByUserIDTest() {
        List<Post> data = new ArrayList<>();
        data.add(generatePost(1));
        when(mockedRepo.findByUserID(1)).thenReturn(data);
        List<Post> ret = testSubject.getByUserID(1);
        Assertions.assertEquals("1",ret.get(0).getBody());
        Assertions.assertEquals(1,ret.get(0).getId());
        Assertions.assertEquals(1,ret.get(0).getUserID());
    }

    @Test
    void getAllTest() {
        List<Post> data = new ArrayList<>();
        data.add(generatePost(1));
        when(mockedRepo.findAll()).thenReturn(data);
        List<Post> ret = testSubject.getAll();
        Assertions.assertEquals("1",ret.get(0).getBody());
        Assertions.assertEquals(1,ret.get(0).getId());
        Assertions.assertEquals(1,ret.get(0).getUserID());
    }
}
