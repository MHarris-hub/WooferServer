package com.app.woofer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.woofer.model.User;
import com.app.woofer.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://jenkins-testhfsga.s3-website-us-east-1.amazonaws.com")
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
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {

        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @GetMapping("/password/{password}")
    public ResponseEntity<List<User>> getUsersByPassword(@PathVariable String password) {
        return ResponseEntity.ok(userService.getUsersByPassword(password));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
        return ResponseEntity.ok(userService.getUsersByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    //POST requests
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        return ResponseEntity.ok(userService.addUser(user));
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        return userService.login(user);
    }

    //DELETE requests
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeUser(id);
    }
}
