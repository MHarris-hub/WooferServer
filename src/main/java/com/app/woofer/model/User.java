package com.app.woofer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public User(int id){
        this.id = id;
    }

//    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "Likes",
//            joinColumns = { @JoinColumn(name = "userId") },
//            inverseJoinColumns = { @JoinColumn(name = "postId") }
//    )
//    private List<Post> likedPosts;


    private String username;
    private String password;
    private String name;
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp")
    private Date timestamp;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
