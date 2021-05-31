package com.app.woofer.controller;

import com.app.woofer.model.ret.ReturnPost;
import com.app.woofer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://jenkins-testhfsga.s3-website-us-east-1.amazonaws.com/", "https://d3s4rsfy4toz8y.cloudfront.net/"})
@RestController
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<ReturnPost> addPost(@RequestBody ReturnPost post){
        return ResponseEntity.ok(new ReturnPost(postService.addPost(post.toEntity())));
    }

    @PutMapping("/post")
    public ResponseEntity<ReturnPost> putPost(@RequestBody ReturnPost post){
        return ResponseEntity.ok(new ReturnPost(postService.putPost(post.updateEntity(postService.getPost(post.getId())))));
    }

//    @DeleteMapping("/post")
//    public void remPost(@RequestBody ReturnPost post){
//        postService.remPost(post);
//    }
    // I dont want to fully delete this but Im suspicious that this wont run correctly

    @DeleteMapping("/post/{id}")
    public void remPost(@PathVariable int id){
        postService.remPost(id);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<ReturnPost> getPost(@PathVariable int id){
        return ResponseEntity.ok(new ReturnPost(postService.getPost(id)));
    }

    @GetMapping("/posts/user/{username}")
    public ResponseEntity<List<ReturnPost>> getPostsByUser(@PathVariable String username){
        return ResponseEntity.ok(ReturnPost.listConvert(postService.getByUsername(username)));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<ReturnPost>> getAllPosts(){
        return ResponseEntity.ok(ReturnPost.listConvert(postService.getAll()));
    }
}
