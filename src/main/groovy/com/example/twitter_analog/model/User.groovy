package com.example.twitter_analog.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {

    @Id
    private String id
    private String username
    private String password
    private String email

    User() {
    }

    User(String username, String password, String email) {
        this.username = username
        this.password = password
        this.email = email
    }

    String getId() {
        return id
    }

    void setId(String id) {
        this.id = id
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }
}
