package com.example.demo.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogOutController {

    @GetMapping
    public String getLogIn() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "logout/logout";
    }
}
