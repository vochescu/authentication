package com.demo.authentication.services;

import com.demo.authentication.model.User;
import com.demo.authentication.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findAllByUsername(username);
    }
}
