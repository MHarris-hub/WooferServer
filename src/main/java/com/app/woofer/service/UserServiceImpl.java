package com.app.woofer.service;


import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.woofer.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    @Override
    public User addUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        logger.info("New user created with { Username: {} }", user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        logger.info("User updated with { ID: {} }", user.getId());
        return userRepository.save(user);
    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByName(String firstName) {
        return userRepository.findUsersByName(firstName);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User login(User user) {
        User storedUser = userRepository.findByUsername(user.getUsername());
        if (storedUser != null && (encoder.matches(user.getPassword(), storedUser.getPassword()))) {
            logger.info("Successful login with credentials: { Username: {} }", user.getUsername());
            return storedUser;
        } else {
            logger.info("Unsuccessful login with credentials: { Username: {} Password: {} } ", user.getUsername(), user.getPassword());
            throw new WooferException("Invalid username/password");
        }
    }

    @Override
    public List<User> getUsersByPassword(String password) {
        return userRepository.findUsersByPassword(password);
    }

    @Override
    public User getUserById(int id) {
        //Optional<User> is an object that can hold values and will only retrieve a value if one is present, BENEFIT: no nullpointExceptions
        Optional<User> userOptional = userRepository.findById(id);
        User user;

        //isPresent() checks for non-null values in userOptional and if true get() will return value held by userOptional
        user = userOptional.orElse(null);

        return user;
    }
}
