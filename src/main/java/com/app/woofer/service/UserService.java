package com.app.woofer.service;

import java.util.List;

import com.app.woofer.model.User;

public interface UserService {

    //Basic CRUD methods
    User addUser(User user);
    User updateUser(User user);
    void removeUser(int id);
    List<User> getUsersByName(String firstName);
    User getByUsername(String username);
    List<User> getUsersByPassword(String password);
    User getUserById(int id);
    User getUserByEmail(String email);
    boolean login(User user);
}
