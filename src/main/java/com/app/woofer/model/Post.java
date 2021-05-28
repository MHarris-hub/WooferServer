package com.app.woofer.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Likes",
            joinColumns = { @JoinColumn(name = "postId") },
            inverseJoinColumns = { @JoinColumn(name = "userId") }
    )
    private List<User> likers;

    @Column(columnDefinition = "default CURRENT_TIMESTAMP")
    private Instant timestamp;
    private int userID;
    private String body;

    public Post(int id, int userID, String body) {
        this.id = id;
        this.userID = userID;
        this.body = body;
    }


}
