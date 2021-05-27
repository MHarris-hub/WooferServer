package com.app.woofer.controller;

import com.app.woofer.model.Post;
import com.app.woofer.model.ret.ReturnPost;
import com.app.woofer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500") //angular running on port 5500
@RestController
public class PostController {

    PostService postService;

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
    // I dont wont to fully delete this but Im suspicious that this wont run correctly

    @DeleteMapping("/post/{id}")
    public void remPost(@PathVariable int id){
        postService.remPost(id);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<ReturnPost> getPost(@PathVariable int id){
        return ResponseEntity.ok(new ReturnPost(postService.getPost(id)));
    }

    @GetMapping("/posts/user/{id}")
    public ResponseEntity<List<ReturnPost>> getPostsByUser(@PathVariable int id){
        return ResponseEntity.ok(ReturnPost.listConvert(postService.getByUserID(id)));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<ReturnPost>> GetAllPosts(){
        return ResponseEntity.ok(ReturnPost.listConvert(postService.getAll()));
    }
}
