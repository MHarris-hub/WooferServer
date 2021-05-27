package com.app.woofer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public Post(int id){
        this.id = id;
    }
   
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", insertable = false, updatable = false )
    private User user;

    private Instant timestamp;
    private int userID;
    private String body;

    public Post(int id, int userID, String body) {
        this.id = id;
        this.userID = userID;
        this.body = body;
    }
}
