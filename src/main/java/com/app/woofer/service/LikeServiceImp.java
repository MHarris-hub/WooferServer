package com.app.woofer.service;

import com.app.woofer.model.Likes;
import com.app.woofer.model.Post;
import com.app.woofer.model.User;
import com.app.woofer.repository.LikesRepository;
import com.app.woofer.repository.PostRepository;
import com.app.woofer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImp implements LikeService {

    private final PostRepository postRepository;
    private final LikesRepository likesRepository;

    @Autowired
    public LikeServiceImp(PostRepository postRepository, LikesRepository likesRepository) {
        this.postRepository = postRepository;
        this.likesRepository = likesRepository;
    }

    @Override
    public int likePost(int userId, int postId) {
        Optional<Post> post = postRepository.findById(postId);
        if(!post.isPresent()) return -1;
        List<User> likers = post.get().getLikers();
        int likes = likers.size();
        for(int i=0;i<likes;i++) if(likers.get(i).getId() == userId) return likes;
        try{
            likesRepository.save(new Likes(userId, postId));
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            return likes;
        }
        return likes + 1;
    }

    @Override
    public List<Integer> likedPosts(int userId) {
        List<Integer> ret = new ArrayList<>();
        List<Likes> find = likesRepository.findByUserId(userId);
        for(Likes like: find) ret.add(like.getPostId());
        return ret;
    }
}
