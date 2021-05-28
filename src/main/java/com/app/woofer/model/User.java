package com.app.woofer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(int id){
        this.id = id;
    }

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Likes",
            joinColumns = { @JoinColumn(name = "userId") },
            inverseJoinColumns = { @JoinColumn(name = "postId") }
    )
    private List<Post> likedPosts;


    private String username;
    private String password;
    private String name;
    private String email;
    private String dob;
    @Column(length = 10)
    private String phone;
}
