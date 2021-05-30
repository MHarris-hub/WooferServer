package com.app.woofer.controller;

import com.app.woofer.exceptions.WooferException;
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
        return followService.getAllFollowers(userId);
    }
    @GetMapping("/follow/follower/{followerId}")
    public ResponseEntity<List<Follow>> getFollowersByFollowId(@PathVariable int followerId){
        return ResponseEntity.ok(followService.getFollowerByFollowId(followerId));
    }
    @GetMapping("/follow/user/{userId}")
    public ResponseEntity<List<Follow>> getFollowersByUserId(@PathVariable int userId){
        return ResponseEntity.ok(followService.getFollowerByUserId(userId));
    }
    @PostMapping("/follow")
    public ResponseEntity<Follow> Follow(@RequestBody Follow follow){
        return ResponseEntity.ok(followService.addFollower(follow));
    }
    @DeleteMapping("/follow")
    public void unfollow(@RequestBody Follow follow){

        if(follow == null){
            throw new WooferException("no null values");
        }
        followService.unfollow(follow);
    }

}
