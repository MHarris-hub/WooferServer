package com.app.woofer.controller;


import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.Follow;
import com.app.woofer.service.FollowService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class FollowControllerTest {

    private FollowService followService;
    private FollowController followController;

    @BeforeEach
    void setUp() {
        followService = mock(FollowService.class);
        followController = new FollowController(followService);
    }

    @Test
    void getAllFollowersTest(){
        when(followService.getAllFollowers(anyInt())).thenReturn(5);
        Assertions.assertEquals(followController.getAllFollowers(5), 5);
    }
    @Test
    void getByFollowId(){
        when(followService.getFollowerByFollowId(anyInt())).thenReturn(null);
        Assertions.assertFalse(followController.getFollowersByFollowId(5) == null);
    }
    @Test
    void getByUserId(){
        when(followService.getFollowerByUserId(anyInt())).thenReturn(null);
        Assertions.assertTrue(followController.getFollowersByUserId(5) != null);
    }
    @Test
    void unfollowTest(){
        Follow follower = new Follow();
        follower.setFollower(null);
        follower.setId(1);
        follower.setUser(null);
        doNothing().when(followService).unfollow(null);
        Assertions.assertThrows(WooferException.class,()->{followController.unfollow(null);});
    }
}
