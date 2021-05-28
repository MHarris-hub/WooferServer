package com.app.woofer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.woofer.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Basic getters using desired field as parameter, find is a keyword of JPA for SQL translation
    List<User> findUsersByName(String name);
    List<User> findUsersByPassword(String password);
    User findByUsername(String username);
    User findUserByEmail(String email);
}
