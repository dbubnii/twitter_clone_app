package com.example.twitter_analog.service

import com.example.twitter_analog.model.Post
import com.example.twitter_analog.repository.PostRepository
import com.example.twitter_analog.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService {

    @Autowired
    private PostRepository postRepository

    @Autowired
    private UserRepository userRepository

    Post createPost(String userId, Post post) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with id $userId does not exist")
        }
        post.setUserId(userId)
        return postRepository.save(post)
    }

    Post getPostById(String postId) {
        return postRepository.findById(postId).orElse(null)
    }

    Post updatePost(String postId, Post post) {
        Post existingPost = getPostById(postId)
        if (existingPost == null) {
            throw new IllegalArgumentException("Post with id $postId not found")
        }
        existingPost.setContent(post.getContent())
        return postRepository.save(existingPost)
    }

    void deletePost(String postId) {
        postRepository.deleteById(postId)
    }

    void likePost(String postId) {
        Post post = getPostById(postId)
        if (post != null) {
            post.like()
            postRepository.save(post)
        }
    }

    void unlikePost(String postId) {
        Post post = getPostById(postId)
        if (post != null) {
            post.unlike()
            postRepository.save(post)
        }
    }
}
