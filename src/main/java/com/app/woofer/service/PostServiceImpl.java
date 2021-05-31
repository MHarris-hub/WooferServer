package com.app.woofer.service;

import com.app.woofer.model.Post;
import com.app.woofer.repository.PostRepository;
import com.app.woofer.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    PostRepository postRepository;
    UserRepository userRepository;
    private static final Logger logger = LogManager.getLogger(PostServiceImpl.class);
    private String blankPass = "password intentionally left blank";

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post addPost(Post post) {
        post = postRepository.save(post);
        post.setUser(userRepository.findById(post.getUserID()).orElse(null));
        logger.info("Post added with { ID: {} User ID: {} }", post.getId(), post.getUserID());
        return post;
    }

    @Override
    public Post putPost(Post post) {
        Post ret = postRepository.save(post);
        ret.getUser().setPassword(blankPass);
        logger.info("Post updated with { ID: {} }", post.getId());
        return ret;
    }

    @Override
    public void remPost(Post post) {
        logger.info("Post deleted with { ID: {} }", post.getId());
        postRepository.delete(post);
    }

    @Override
    public void remPost(int id) {
        logger.info("Post deleted with { ID: {} }", id);
        postRepository.deleteById(id);
    }

    @Override
    public Post getPost(int id) {
        Post ret = postRepository.findById(id).orElse(null);
        if (ret != null){
            ret.getUser().setPassword(blankPass);
        }
        logger.info("Post retrieved with { ID: {} }", id);
        return ret;
    }

    @Override
    public List<Post> getByUserID(int id) {
        List<Post> ret = postRepository.findByUserID(id);
        for (Post i: ret) {
            i.getUser().setPassword(blankPass);
        }
        logger.info("Posts retrieved for user with { ID: {} }", id);
        return ret;
    }

    @Override
    public List<Post> getAll() {
        List<Post> ret = postRepository.findAll();
        for (Post i: ret) {
            i.getUser().setPassword(blankPass);
        }
        logger.info("All users retrieved");
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
