package com.app.woofer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.woofer.model.User;
import com.app.woofer.service.UserService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //GET requests
    @GetMapping("/user/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/user/password/{password}")
    public List<User> getUsersByPassword(@PathVariable String password) {
        return userService.getUsersByPassword(password);
    }

    @GetMapping("/user/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    //POST requests
    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/user/login")
    public boolean login(@RequestBody User user){return userService.login(user);}

    //DELETE requests
    @DeleteMapping("/user/delete/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }
}
