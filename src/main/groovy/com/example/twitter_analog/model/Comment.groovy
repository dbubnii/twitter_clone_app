package com.example.twitter_analog.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Comment {

    @Id
    private String id
    private String content

    @DBRef
    private User author

    @DBRef
    private Post post

    Comment() {
    }

    Comment(String content, User author, Post post) {
        this.content = content
        this.author = author
        this.post = post
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

    User getAuthor() {
        return author
    }

    void setAuthor(User author) {
        this.author = author
    }

    Post getPost() {
        return post
    }

    void setPost(Post post) {
        this.post = post
    }
}
