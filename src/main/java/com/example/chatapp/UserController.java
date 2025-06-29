package com.example.chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    // Login
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginData) {
        User user = userRepository.findByUsername(loginData.getUsername()).orElse(null);

        if (user == null) {
            return "User not found!";
        }

        if (!user.getPassword().equals(loginData.getPassword())) {
            return "Invalid password!";
        }

        return "Login successful!";
    }
}
