package com.app.woofer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "id")
    private Post post;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant timestamp;
    private String body;
}