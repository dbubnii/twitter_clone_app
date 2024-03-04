package com.example.twitter_analog.controller

import com.example.twitter_analog.model.User
import com.example.twitter_analog.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private UserService userService

    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser)
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> getUserById(@PathVariable String userId) {
        User user = userService.getUserById(userId)
        return ResponseEntity.ok(user)
    }

    @PutMapping("/{userId}")
    ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user)
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/{userId}/follow/{followedUserId}")
    ResponseEntity<Void> followUser(@PathVariable String userId, @PathVariable String followedUserId) {
        userService.followUser(userId, followedUserId)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{userId}/unfollow/{followedUserId}")
    ResponseEntity<Void> unfollowUser(@PathVariable String userId, @PathVariable String followedUserId) {
        userService.unfollowUser(userId, followedUserId)
        return ResponseEntity.ok().build()
    }
}

