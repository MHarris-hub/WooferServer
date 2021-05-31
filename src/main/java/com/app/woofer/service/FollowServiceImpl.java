package com.app.woofer.service;

import com.app.woofer.model.Follow;
import com.app.woofer.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements  FollowService{

    private final FollowRepository followRepository;
    @Autowired
    public FollowServiceImpl(FollowRepository followRepository){
        this.followRepository = followRepository;
    }
    @Override
    public int getAllFollowers(int userId) {
        return followRepository.countByUser_Id(userId);
    }

    @Override
    public Follow addFollower(Follow follow) {

        List<Follow> checkFollow = followRepository.findByFollower_Id(follow.getFollower().getId());

        for(Follow followTest : checkFollow){
            if(follow.getFollower().getId() == followTest.getFollower().getId() &&
                    follow.getUser().getId() == followTest.getUser().getId()){
                return null;
            }else if(follow.getFollower().getId() == follow.getUser().getId()){
                return null;
            }
        }
        return followRepository.save(follow);
    }

    @Override
    public List<Follow> getFollowerByFollowId(int id) {
        return followRepository.findByFollower_Id(id);
    }

    @Override
    public void unfollow(int followId) {
           followRepository.deleteById(followId);
    }
}
