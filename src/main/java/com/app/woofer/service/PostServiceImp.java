package com.app.woofer.service;

import com.app.woofer.model.Post;
import com.app.woofer.repository.PostRepository;
import com.app.woofer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImp implements PostService{

    PostRepository postRepository;
    UserRepository userRepository;
    private String blankPass = "password intentionally left blank";

    @Autowired
    public PostServiceImp(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post addPost(Post post) {
        post = postRepository.save(post);
        post.setUser(userRepository.findById(post.getUserID()).orElse(null));
        return post;
    }

    @Override
    public Post putPost(Post post) {
        Post ret = postRepository.save(post);
        ret.getUser().setPassword(blankPass);
        return ret;
    }

    @Override
    public void remPost(Post post) {
        postRepository.delete(post);
    }

    @Override
    public void remPost(int id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post getPost(int id) {
        Post ret = postRepository.findById(id).orElse(null);
        if (ret != null){
            ret.getUser().setPassword(blankPass);
        }
        return ret;
    }

    @Override
    public List<Post> getByUserID(int id) {
        List<Post> ret = postRepository.findByUserID(id);
        for (Post i: ret) {
            i.getUser().setPassword(blankPass);
        }
        return ret;
    }

    @Override
    public List<Post> getAll() {
        List<Post> ret = postRepository.findAll();
        for (Post i: ret) {
            i.getUser().setPassword(blankPass);
        }
        return ret;
    }

    @Override
    public List<Post> getByUsername(String username) {
        List<Post> ret = postRepository.findByUserUsername(username);
        for (Post i: ret) {
            i.getUser().setPassword(blankPass);
        }
        return ret;
    }
}
