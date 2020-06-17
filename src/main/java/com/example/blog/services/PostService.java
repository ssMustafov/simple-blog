package com.example.blog.services;

import com.example.blog.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author smustafov
 */
public interface PostService {

    Page<Post> findAll(Pageable pageable);

    Optional<Post> findById(Long id);

    Post create(Post post);

    Optional<Post> update(Long id, Post post);

    void deleteById(Long id);

}
