package com.app.woofer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.GeneratorStrategy;

import javax.persistence.*;

@Entity
@Table(name = "Likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public Likes(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }

    private int userId;
    private int postId;
}
