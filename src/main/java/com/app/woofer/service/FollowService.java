package com.app.woofer.service;

import com.app.woofer.model.Follow;

import java.util.List;

public interface FollowService {
    int getAllFollowers(int userId);
    Follow addFollower(Follow follow);
    List<Follow> getFollowerByFollowId(int id);
    public List<Follow> getFollowerByUserId(int id);
    void unfollow(int followId);
}
