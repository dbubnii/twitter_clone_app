package com.example.twitter_analog.service

import com.example.twitter_analog.model.User
import com.example.twitter_analog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private UserRepository userRepository

    User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username ${user.getUsername()} is already taken")
        }
        return userRepository.save(user)
    }

    User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null)
    }

    User updateUser(String userId, User user) {
        User existingUser = getUserById(userId)
        if (existingUser == null) {
            throw new IllegalArgumentException("User with id $userId not found")
        }
        existingUser.setUsername(user.getUsername())
        existingUser.setPassword(user.getPassword())
        existingUser.setEmail(user.getEmail())
        return userRepository.save(existingUser)
    }

    void deleteUser(String userId) {
        userRepository.deleteById(userId)
    }

    void followUser(String userId, String followedUserId) {
        User user = getUserById(userId)
        User followedUser = getUserById(followedUserId)
        if (user == null || followedUser == null) {
            throw new IllegalArgumentException("Invalid user IDs")
        }
        user.follow(followedUser)
        userRepository.save(user)
    }

    void unfollowUser(String userId, String followedUserId) {
        User user = getUserById(userId)
        User followedUser = getUserById(followedUserId)
        if (user == null || followedUser == null) {
            throw new IllegalArgumentException("Invalid user IDs")
        }
        user.unfollow(followedUser)
        userRepository.save(user)
    }
}

