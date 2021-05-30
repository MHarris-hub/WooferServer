package com.app.woofer.service;

import java.util.List;

public interface LikeService {
    int likePost(int userId, int postId);

    List<Integer> likedPosts(int userId);
}
