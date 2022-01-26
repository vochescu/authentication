package com.demo.authentication.services;

import com.demo.authentication.model.RegistrationRequest;
import com.demo.authentication.model.RegistrationResponse;
import com.demo.authentication.model.Role;
import com.demo.authentication.model.User;
import com.demo.authentication.repositories.UserRepository;
import com.demo.authentication.utils.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers(){
       return userRepository.findAll();
    }

    public User getUser(String username) {
        return passwordEncoder.obfuscatePassword(userRepository.findAllByUsername(username));
    }

    public RegistrationResponse saveUser(RegistrationRequest requestBody) {
        User user = passwordEncoder.encodePassword(new User(
                requestBody.getUsername(),
                requestBody.getPassword(),
                getCreationTime(),
                Role.valueOf(requestBody.getRole())
                ));
        //TODO
//        userRepository.findAllByUsername(user.getUsername());
        userRepository.save(user);
        return new RegistrationResponse(user.getUsername());
    }

    private String getCreationTime()  {
        Calendar calendar  = Calendar.getInstance();
        Date date = new Date(calendar.toInstant().toEpochMilli());
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'").format(date);
    }
}
