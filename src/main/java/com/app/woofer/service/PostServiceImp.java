package com.app.woofer.service;

import com.app.woofer.model.Post;
import com.app.woofer.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post putPost(Post post) {
        Post ret = postRepository.save(post);
        ret.getUser().setPassword("password intentionally left blank");
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
            ret.getUser().setPassword("password intentionally left blank");
        }
        return ret;
    }

    @Override
    public List<Post> getByUserID(int id) {
        List<Post> ret = postRepository.findByUserID(id);
        for (Post i: ret) {
            i.getUser().setPassword("password intentionally left blank");
        }
        return ret;
    }

    @Override
    public List<Post> getAll() {
        List<Post> ret = postRepository.findAll();
        for (Post i: ret) {
            i.getUser().setPassword("password intentionally left blank");
        }
        return ret;
    }
}
