package com.app.woofer.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String dob;
    @Column(length = 10)
    private String phone;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
