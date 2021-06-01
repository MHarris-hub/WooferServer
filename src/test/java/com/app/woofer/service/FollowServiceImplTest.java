package com.app.woofer.service;

import com.app.woofer.model.Follow;
import com.app.woofer.model.User;
import com.app.woofer.repository.FollowRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class FollowServiceImplTest {

    private FollowRepository followRepository;
    private FollowService followService;

    @BeforeEach
    void first(){
        followRepository = mock(FollowRepository.class);
        followService = new FollowServiceImpl(followRepository);
    }
    @Test
    void addFollowerTest(){
        Follow followuser = new Follow();
        followuser.setFollower(new User(2));
        followuser.setUser(new User(2));


        List<Follow> followList = new ArrayList<>();
        followList.add(followuser);

        when(followRepository.findByFollower_Id(followuser.getFollower().getId())).thenReturn(followList);
        Assertions.assertFalse(followService.addFollower(followuser) == followList);
    }
    @Test
    void addFollowerTest2(){
        Follow followuser = new Follow();
        followuser.setFollower(new User(2));
        followuser.setUser(new User(3));

        Follow followuser2 = new Follow();
        followuser.setFollower(new User(3));
        followuser.setUser(new User(3));


        List<Follow> followList = new ArrayList<>();
        followList.add(followuser);

        when(followRepository.findByFollower_Id(followuser.getFollower().getId())).thenReturn(followList);
        Assertions.assertFalse(followService.addFollower(followuser) == followList);
    }

    @Test
    void getFollowerByFollowerTest(){
        followService.getFollowerByFollowId(1);
        verify(followRepository).findByFollower_Id(1);
    }
    @Test
    void getFollowerByUserTest(){
        followService.getFollowerByUserId(1);
        verify(followRepository).findByUser_Id(1);
    }
    @Test
    void unfollowTest(){
        followService.unfollow(1);
        verify(followRepository).deleteById(1);
    }
    @Test
    void getAllTest(){
        followService.getAllFollowers(1);
        verify(followRepository).countByUser_Id(1);
    }
}
