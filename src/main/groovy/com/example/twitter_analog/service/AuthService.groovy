package com.example.twitter_analog.service

import com.example.twitter_analog.model.User
import com.example.twitter_analog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService {

    @Autowired
    private UserRepository userRepository

    @Autowired
    private PasswordEncoder passwordEncoder

    boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()))
        userRepository.save(user)
        return true
    }

    User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username)
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user
        }
        return null
    }
}
