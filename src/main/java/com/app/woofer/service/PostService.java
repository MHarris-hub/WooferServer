package com.app.woofer.service;

import com.app.woofer.model.Post;

import java.util.List;

public interface PostService {
    Post addPost(Post post);
    Post putPost(Post post);
    void remPost(Post post);
    void remPost(int id);
    Post getPost(int id);

    List<Post> getByUserID(int id);
    List<Post> getAll();
}
