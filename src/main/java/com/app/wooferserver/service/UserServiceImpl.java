package com.app.wooferserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.wooferserver.model.User;
import com.app.wooferserver.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void removeUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public List<User> getUsersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return userRepository.findUsersByFirstName(firstName);
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		// TODO Auto-generated method stub
		return userRepository.findUsersByLastName(lastName);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(username);
	}

	@Override
	public List<User> getUsersByPassword(String password) {
		// TODO Auto-generated method stub
		return userRepository.findUsersByPassword(password);
	}

	@Override
	public User getUserById(int id) {
		//Optional<User> is an object that can hold values and will only retrieve a value if one is present, BENEFIT: no nullpointExceptions
		Optional<User> userOptional = userRepository.findById(id);
		User user;
		
		//isPresent() checks for non-null values in userOptional and if true get() will return value held by userOptional
		if(userOptional.isPresent()) {
			user  = userOptional.get();
		}else {
			user = null;
		}
		
		return user;
	}
	
	

}
