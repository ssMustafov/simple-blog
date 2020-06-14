package com.example.blog.services;

import com.example.blog.models.Post;

import java.util.List;
import java.util.Optional;

/**
 * @author smustafov
 */
public interface PostService {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    Post create(Post post);

    Optional<Post> update(Long id, Post post);

    void deleteById(Long id);

}
