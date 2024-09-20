package org.example.jenkinslab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class home {
    @GetMapping({"home"})
    public String home() {
        return "Hello world";
    }
}
