package com.app.woofer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "followers")
@Data
@NoArgsConstructor
public class Follow {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "followerID", referencedColumnName = "id")
    private User follower;
}
