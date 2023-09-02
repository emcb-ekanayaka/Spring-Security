package com.example.securitytest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/notice")
@CrossOrigin
public class NotificationController {

    @GetMapping("/get-notice")
    public String getTestData() {
        return "Hello this is notice...!";
    }
}
