package com.app.woofer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(int id){
        this.id = id;
    }


    private String username;
    private String password;
    private String name;
    private String email;
    private String dob;
    @Column(length = 10)
    private String phone;
}
