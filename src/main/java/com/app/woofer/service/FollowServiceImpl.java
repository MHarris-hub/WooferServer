package com.app.woofer.service;

import com.app.woofer.model.Follow;
import com.app.woofer.repository.FollowRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements  FollowService{

    private final FollowRepository followRepository;
    private static final Logger logger = LogManager.getLogger(FollowServiceImpl.class);

    @Autowired
    public FollowServiceImpl(FollowRepository followRepository){
        this.followRepository = followRepository;
    }
    @Override
    public int getAllFollowers(int userId) {
        logger.info("All followers retrieved for user with { ID: {} }", userId);
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
        logger.info("Follow added with id { ID: {} }", follow.getId());
        return followRepository.save(follow);
    }

    @Override
    public List<Follow> getFollowerByFollowId(int id) {
        logger.info("Followers retrieved with follow id { ID: {} }", id);
        return followRepository.findByFollower_Id(id);
    }

    @Override
    public List<Follow> getFollowerByUserId(int id) {
        logger.info("Followers retrieved for User with { ID: {} }", id);
        return followRepository.findByUser_Id(id);
    }

    @Override
    public void unfollow(Follow follow) {

        List<Follow> foundUserId = followRepository.findByUser_Id(follow.getUser().getId());
        List<Follow> foundFollowerId = followRepository.findByFollower_Id(follow.getFollower().getId());

        for(Follow follower : foundUserId){
            if(foundFollowerId.contains(follower)){
                followRepository.deleteById(follower.getId());
            }
        }
        logger.info("Follower with { ID: {} } has unfollowed User with { ID: {} }", follow.getFollower().getId(), follow.getUser().getId());
    }
}
