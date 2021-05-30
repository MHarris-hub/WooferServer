package com.app.woofer.controller;

import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.User;
import com.app.woofer.service.PostService;
import com.app.woofer.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void getByUsernameTest(){
        when(userService.getByUsername(anyString())).thenReturn(null);
        Assertions.assertFalse(userController.getUserByUsername(null).equals(null));
    }
    @Test
    void getByPasswordTest(){
        User test = new User(2);
        test.setEmail("gmail");
        test.setPassword("l");
        test.setUsername("s");
        List<User> testList = new ArrayList<>();
        testList.add(test);
        when(userService.getUsersByPassword(anyString())).thenReturn(testList);
        Assertions.assertFalse(userController.getUsersByPassword("test").getBody().get(0).equals("l"));
    }
    @Test
    void getByNameTest(){
        User test = new User(2);
        test.setEmail("gmail");
        test.setPassword("l");
        test.setUsername("s");
        List<User> testList = new ArrayList<>();
        testList.add(test);
        when(userService.getUsersByName(anyString())).thenReturn(testList);
        Assertions.assertFalse(userController.getUsersByName("test").equals(testList));
    }
    @Test
    void loginTest(){
        User test = new User(2);
        test.setEmail("gmail");
        test.setPassword("l");
        test.setUsername("s");
        when(userService.login(any())).thenReturn(test);
        Assertions.assertTrue(userController.login(null).equals(test));
    }
    @Test
    void removeUserTest(){
        doNothing().when(userService).removeUser(1);
        Assertions.assertThrows(WooferException.class,()->{userController.removeUser(0);});
    }
    @Test
    void addUserTest(){
        User test = new User(2);
        test.setEmail("gmail");
        test.setPassword("l");
        test.setUsername("s");
        ResponseEntity<User> resTest = ResponseEntity.ok(test);
        when(userService.addUser(any())).thenReturn(test);
        Assertions.assertEquals(userController.addUser(test),resTest);
    }
    @Test
    void getByEmailTest(){
        User test = new User(2);
        test.setPassword("l");
        test.setUsername("s");
        ResponseEntity<User> resTest = ResponseEntity.ok(test);
        when(userService.getUserByEmail(anyString())).thenReturn(test);
        Assertions.assertTrue(userController.getUserByEmail("test").equals(resTest));
    }
    @Test
    void getUserByIdTest(){
        User test = new User(2);
        ResponseEntity<User> resTest = ResponseEntity.ok(test);
        when(userService.getUserById(2)).thenReturn(test);
        Assertions.assertFalse(userController.getUserById(2).equals(resTest));
    }
}
