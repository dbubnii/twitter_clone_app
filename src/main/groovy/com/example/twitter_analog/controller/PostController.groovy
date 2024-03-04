package com.example.twitter_analog.controller

import com.example.twitter_analog.model.Post
import com.example.twitter_analog.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/posts")
class PostController {

    @Autowired
    private PostService postService

    @PostMapping
    ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post)
        return ResponseEntity.created(createdPost).body(createdPost)
    }

    @GetMapping("/{postId}")
    ResponseEntity<Post> getPostById(@PathVariable String postId) {
        Post post = postService.getPostById(postId)
        return ResponseEntity.ok(post)
    }

    @PutMapping("/{postId}")
    ResponseEntity<Post> updatePost(@PathVariable String postId, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(postId, post)
        return ResponseEntity.ok(updatedPost)
    }

    @DeleteMapping("/{postId}")
    ResponseEntity<Void> deletePost(@PathVariable String postId) {
        postService.deletePost(postId)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/{postId}/like")
    ResponseEntity<Void> likePost(@PathVariable String postId) {
        postService.likePost(postId)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{postId}/like")
    ResponseEntity<Void> unlikePost(@PathVariable String postId) {
        postService.unlikePost(postId)
        return ResponseEntity.ok().build()
    }

}