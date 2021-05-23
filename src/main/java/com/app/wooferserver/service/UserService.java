package com.app.wooferserver.service;

import java.util.List;

import com.app.wooferserver.model.User;

public interface UserService {
	
	//Basic CRUD methods
	public User addUser(User user);
	public User updateUser(User user);
	public void removeUser(User user);
	public List<User> getUsersByFirstName(String firstName);
	public List<User> getUsersByLastName(String lastName);
	public User getUserByUsername(String username);
	public List<User> getUsersByPassword(String password);
	public User getUserById(int id); 

}
