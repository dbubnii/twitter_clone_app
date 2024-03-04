package com.example.twitter_analog.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "posts")
class Post {

    @Id
    private String id
    private String content
    private String userId
    private List<String> likedBy
    private List<Comment> comments

    Post(String content, String userId) {
        this.content = content
        this.userId = userId
        this.likedBy = []
        this.comments = []
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getContent() {
        return content
    }

    void setContent(String content) {
        this.content = content
    }

    String getUserId() {
        return userId
    }

    void setUserId(String userId) {
        this.userId = userId
    }

    List<String> getLikedBy() {
        return likedBy
    }

    void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy
    }

    List<Comment> getComments() {
        return comments
    }

    void setComments(List<Comment> comments) {
        this.comments = comments
    }
}
