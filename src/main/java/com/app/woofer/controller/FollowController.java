package com.app.woofer.controller;

import com.app.woofer.exceptions.NotFoundException;
import com.app.woofer.model.Follow;
import com.app.woofer.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class FollowController {

    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService){
        this.followService = followService;
    }

    @GetMapping("/follow/countbyuser/{userId}")
    public  int getAllFollowers(@PathVariable int userId){
        if (followService.getFollowerByUserId(userId) == null)
            throw new NotFoundException("Could not retrieve followers");

        return followService.getAllFollowers(userId);
    }

    @GetMapping("/follow/follower/{followerId}")
    public ResponseEntity<List<Follow>> getFollowersByFollowId(@PathVariable int followerId){
        if (followService.getFollowerByUserId(followerId) == null)
            throw new NotFoundException("Could not retrieve followers");

        return ResponseEntity.ok(followService.getFollowerByFollowId(followerId));
    }

    @GetMapping("/follow/user/{userId}")
    public ResponseEntity<List<Follow>> getFollowersByUserId(@PathVariable int userId){
        if (followService.getFollowerByUserId(userId) == null)
            throw new NotFoundException("Could not retrieve followers");

        return ResponseEntity.ok(followService.getFollowerByUserId(userId));
    }

    @PostMapping("/follow")
    public ResponseEntity<Follow> Follow(@RequestBody Follow follow){
        if (follow.getUser().getUsername() == null)
            throw new NotFoundException("Could not follow user");

        return ResponseEntity.ok(followService.addFollower(follow));
    }

    @DeleteMapping("/follow")
    public void unfollow(@RequestBody Follow follow){
        followService.unfollow(follow);
    }

}
