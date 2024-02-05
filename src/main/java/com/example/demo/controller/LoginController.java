package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class LoginController {

    @GetMapping("/user")
    public String getUser() {
        return "Welcome, User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Welcome, Admin";
    }
}

