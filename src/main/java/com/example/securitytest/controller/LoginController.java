package com.example.securitytest.controller;

import com.example.securitytest.Repository.UserRepo;
import com.example.securitytest.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class LoginController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userDao;

    public LoginController(PasswordEncoder passwordEncoder, UserRepo userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        ResponseEntity response = null;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User userSave = userDao.save(user);

            if (userSave.getId()>0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Successfully Created..");
            }
        }catch (Exception e){
           response = ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body("Error " + e);
        }

        return response;

    }

}
