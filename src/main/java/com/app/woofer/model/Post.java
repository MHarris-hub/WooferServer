package com.app.woofer.model;

import com.app.woofer.model.User;
import lombok.AllArgsConstructor;
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

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User user;

    private Instant timestamp;
    @Column(insertable = false, updatable = false)
    private int userID; //dont delete this -mish
    private String body;

    public Post(int id, int userID, String body) {
        this.id = id;
        this.userID = userID;
        this.body = body;
    }
}
