package com.example.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProfileController {

    @GetMapping("/profile")
    public Map<String, Object> getProfile() {
        return Map.of(
            "id", 101,
            "name", "Sriya",
            "course", "B.Tech CSE",
            "message", "Profile API accessed successfully"
        );
    }
}
