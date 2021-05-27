package com.app.woofer.model;

import com.app.woofer.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

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
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User user;

    private Instant timestamp;
    @Column(insertable = false, updatable = false)
    private int userID; //delete this?
    private String body;
}
