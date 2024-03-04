package com.example.twitter_analog.repository

import com.example.twitter_analog.model.Comment
import org.springframework.data.mongodb.repository.MongoRepository

interface CommentRepository extends MongoRepository<Comment, String> {
}
