package com.example.twitter_analog.controller

import com.example.twitter_analog.model.User
import com.example.twitter_analog.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {
    @Autowired
    private AuthService authService

    @PostMapping("/api/auth/register")
    ResponseEntity<String> registerUser(@RequestBody User user) {
        if (authService.registerUser(user)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully")
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to register user")
    }

    @PostMapping("/api/auth/login")
    ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        if (authService.login(credentials["username"], credentials["password"])) {
            return ResponseEntity.ok("Login successful")
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password")
    }

    @PostMapping("/api/auth/logout")
    ResponseEntity<String> logout() {
        authService.logout()
        return ResponseEntity.ok("Logged out successfully")
    }
}
