package com.app.woofer.controller;

import com.app.woofer.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") //angular running on port 5500
@RestController
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping("/like/{userId}/{postId}")
    public ResponseEntity<Integer> likePost(@PathVariable int userId, @PathVariable int postId){
        return ResponseEntity.ok(likeService.likePost(userId, postId));
    }
}
