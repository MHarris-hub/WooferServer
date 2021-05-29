package com.app.woofer.service;

import com.app.woofer.exceptions.WooferException;
import com.app.woofer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.woofer.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    @Override
    public User addUser(User user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
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
            return storedUser;
        } else {
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
