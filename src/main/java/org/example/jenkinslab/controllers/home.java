package org.example.jenkinslab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
    @GetMapping({"", "/", "/home"})
    public String home() {
        return "Hello world";
    }
}
