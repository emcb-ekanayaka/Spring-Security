package com.example.securitytest.Repository;

import com.example.securitytest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface UserRepo extends JpaRepository<User, Integer> {

    List<User> findByEmail(String username);
}
