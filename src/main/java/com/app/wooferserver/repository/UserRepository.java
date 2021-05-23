package com.app.wooferserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.wooferserver.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Basic getters using desired field as parameter, find is a keyword of JPA for SQL translation
	public List<User> findUsersByLastName(String lastName);
	public List<User> findUsersByFirstName(String firstName);
	public List<User> findUsersByPassword(String password);
	public User findUserByUsername(String username);
	
}
