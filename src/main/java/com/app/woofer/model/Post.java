package com.app.woofer.model;

import com.app.woofer.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID", referencedColumnName = "id", updatable = false, insertable = false)
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
