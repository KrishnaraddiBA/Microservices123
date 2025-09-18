package com.authenticationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class WelcomeController {

//api/v1/admin/welcome
    @GetMapping("/welcome")
    public String welcomeAdmin() {
        return "Welcome admin";
    }

}