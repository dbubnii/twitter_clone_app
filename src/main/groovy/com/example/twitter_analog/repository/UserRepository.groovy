package com.example.twitter_analog.repository

import com.example.twitter_analog.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username)
}