package com.app.woofer.controller;

import com.app.woofer.model.Post;
import com.app.woofer.model.ret.ReturnPost;
import com.app.woofer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500") //angular running on port 5500
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post")
    public ReturnPost addPost(@RequestBody Post post){
        return new ReturnPost(postService.addPost(post));
    }

    @PutMapping("/post")
    public ReturnPost putPost(@RequestBody Post post){
        return new ReturnPost(postService.putPost(post));
    }

    @DeleteMapping("/post")
    public void remPost(@RequestBody Post post){
        postService.remPost(post);
    }

    @DeleteMapping("/post/{id}")
    public void remPost(@PathVariable int id){
        postService.remPost(id);
    }

    @GetMapping("/post/{id}")
    public ReturnPost getPost(@RequestBody int id){
        return new ReturnPost(postService.getPost(id));
    }

    @GetMapping("/posts/user/{id}")
    public List<ReturnPost> getPostsByUser(@RequestBody int id){
        return ReturnPost.listConvert(postService.getByUserID(id));
    }

    @GetMapping("/posts")
    public List<ReturnPost> GetAllPosts(){
        return ReturnPost.listConvert(postService.getAll());
    }
}
