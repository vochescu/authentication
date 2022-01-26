package com.demo.authentication.repositories;

import com.demo.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    User findAllByUsername(String username);
}
