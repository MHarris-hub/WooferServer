package com.app.woofer.controller;

import java.util.List;

import com.app.woofer.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(UserController.class);

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
    public User getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        //logger.info("Searching for user with id: {}", id);
        if (user == null) {
            logger.info("User not found with id: { {} }", id);
            throw new NotFoundException("User not found");
        }
        return user;
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
    public User login(@RequestBody User user){
        return userService.login(user);
    }

    //DELETE requests
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable int id) {

        userService.removeUser(id);
    }
}
