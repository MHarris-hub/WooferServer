package com.app.woofer.service;

import com.app.woofer.exceptions.NotFoundException;
import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.User;
import com.app.woofer.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserRepository userRepository;
    private UserService userService;
    private BCryptPasswordEncoder bcrypt;
    private Object Optional;

    @BeforeEach
    void first(){
        userRepository = mock(UserRepository.class);
        bcrypt = mock(BCryptPasswordEncoder.class);
        userService = new UserServiceImpl(userRepository, bcrypt);
    }

    @Test
    void loginTest(){
        when(userRepository.findByUsername(any())).thenReturn(null);
        Assertions.assertThrows(NullPointerException.class,()->{
            userService.login(null);
        });
    }
    @Test
    void loginTest2(){

        when(bcrypt.matches(anyString(),anyString())).thenReturn(false);
        Assertions.assertThrows(NotFoundException.class,()->{
            userService.login(new User(1));
        });
    }
    @Test
    void addUserTest(){
        User user = new User(1);
        user.setPassword("l");
        when(bcrypt.encode(anyString())).thenReturn("");
        Assertions.assertTrue(userService.addUser(new User(1))!=user);
    }
    @Test
    void getUsersByUsernameTest(){
        User user = new User(1);
        user.setEmail("ale");
        when(userRepository.findByUsername(anyString())).thenReturn(user);
        Assertions.assertTrue(userService.getByUsername("ale") == user);
    }
    @Test
    void getUsersByPasswordTest(){
        User user = new User(1);
        user.setEmail("ale");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findUsersByPassword(anyString())).thenReturn(userList);
        Assertions.assertTrue(userService.getUsersByPassword("ale") == userList);
    }
    @Test
    void getUsersByEmailTest(){
        User user = new User(1);
        user.setEmail("ale");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findUserByEmail(anyString())).thenReturn(user);
        Assertions.assertTrue(userService.getUserByEmail("ale") == user);
    }
    @Test
    void getUsersByNameTest(){
        User user = new User(1);
        user.setName("ale");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findUsersByName(anyString())).thenReturn(userList);
        Assertions.assertTrue(userService.getUsersByName("ale") == userList);
    }
    @Test
    void getUserIdTest(){
        //when(Optional<User> userOptional = userRepository.findById(id));
    }
    @Test
    void updateUserTest(){

    }
}
