package com.app.woofer.controller;

import com.app.woofer.exceptions.NotFoundException;
import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.Follow;
import com.app.woofer.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://jenkins-testhfsga.s3-website-us-east-1.amazonaws.com:80", "https://d3s4rsfy4toz8y.cloudfront.net:443", "*"})
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping("/follow/countbyuser/{userId}")
    public int getAllFollowers(@PathVariable int userId) {

        return followService.getAllFollowers(userId);
    }

    @GetMapping("/follow/follower/{followerId}")
    public ResponseEntity<List<Follow>> getFollowersByFollowId(@PathVariable int followerId) {

        return ResponseEntity.ok(followService.getFollowerByFollowId(followerId));
    }


    @PostMapping("/follow")
    public ResponseEntity<Follow> Follow(@RequestBody Follow follow) {
        return ResponseEntity.ok(followService.addFollower(follow));
    }

    @DeleteMapping("/follow/{followId}")
    public void unfollow(@PathVariable int followId) {
        followService.unfollow(followId);

    }
}
