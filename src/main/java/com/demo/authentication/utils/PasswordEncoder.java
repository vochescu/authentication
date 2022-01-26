package com.demo.authentication.utils;

import com.demo.authentication.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public User encodePassword(User user){
        User copy =  new User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()), user.getCreationTimestamp(), user.getRole());
        return copy;
    }

    public User obfuscatePassword(User user){
        User copy =  new User(user.getUsername(), "******", user.getCreationTimestamp(), user.getRole());
        return copy;
    }

    public String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}