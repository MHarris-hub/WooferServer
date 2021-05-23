package com.app.wooferserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.wooferserver.model.User;
import com.app.wooferserver.service.UserService;



@CrossOrigin(origins = "http://localhost:5500") //angular running on port 5500
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//GET requests
	@GetMapping("/user/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@GetMapping("/user/password/{password}")
	public List<User> getUsersByPassword(@PathVariable String password) {
		return userService.getUsersByPassword(password);
	}
	
	@GetMapping("/user/firstName/{firstName}")
	public List<User> getUsesrByFirstName(@PathVariable String firstName) {
		return userService.getUsersByFirstName(firstName);
	}
	
	@GetMapping("/user/lastName/{username}")
	public List<User> getUserByLastName(@PathVariable String lastName) {
		return userService.getUsersByLastName(lastName);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	//POST requests
	@PostMapping("/user/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	//DELETE requests
	@DeleteMapping("/user/delete")
	public void removeUser(@RequestBody User user) {
		userService.removeUser(user);
	}
	
	
	
}
