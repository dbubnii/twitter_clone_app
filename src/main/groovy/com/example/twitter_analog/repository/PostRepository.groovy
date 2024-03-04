package com.example.twitter_analog.repository

import com.example.twitter_analog.model.Post
import org.springframework.data.mongodb.repository.MongoRepository

interface PostRepository extends MongoRepository<Post, String> {
}