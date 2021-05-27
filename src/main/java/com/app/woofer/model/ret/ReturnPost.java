package com.app.woofer.model.ret;

import com.app.woofer.model.Post;
import javafx.geometry.Pos;
import lombok.Data;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Data
public class ReturnPost {
    private String username;
    private String name;
    private String body;
    private int Id;
    private int userId;
    private int likes;
    private int comments;

    public ReturnPost(Post post){
        username = post.getUser().getUsername();
        name = post.getUser().getName();
        body = post.getBody();
        likes = 0;
        comments = 0;
        userId = post.getUserID();
        Id = post.getId();
    }

    public static List<ReturnPost> listConvert(List<Post> x){
        List<ReturnPost> ret = new ArrayList<>();
        for (Post i : x) ret.add(new ReturnPost(i));
        return ret;
    }

    public Post toEntity(){
        return new Post(Id, userId, body);
    }

    public Post updateEntity(Post post){
        post.setBody(body);
        post.setUserID(userId);
        return post;
    }
}
