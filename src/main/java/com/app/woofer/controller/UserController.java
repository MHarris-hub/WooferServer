package com.app.woofer.controller;

import java.util.List;

import com.app.woofer.exceptions.WooferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.woofer.model.User;
import com.app.woofer.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://jenkins-testhfsga.s3-website-us-east-1.amazonaws.com")
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //GET requests
    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/password/{password}")
    public List<User> getUsersByPassword(@PathVariable String password) {
        return userService.getUsersByPassword(password);
    }

    @GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null) {
            throw new WooferException("User not found");
        }
        return user;
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    //POST requests
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    //DELETE requests
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }
}
