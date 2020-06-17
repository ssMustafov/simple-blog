package com.example.blog.services;

import com.example.blog.entity.PostEntity;
import com.example.blog.models.Post;
import com.example.blog.repositories.PostRepository;
import com.example.blog.services.mappers.PostMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author smustafov
 */
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable).map(postMapper::fromEntity);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id).map(postMapper::fromEntity);
    }

    @Override
    public Post create(Post post) {
        PostEntity postEntity = postMapper.toEntity(post);
        PostEntity saved = postRepository.save(postEntity);
        return postMapper.fromEntity(saved);
    }

    @Override
    public Optional<Post> update(Long id, Post post) {
        return postRepository.findById(id).map(postEntity -> {
            postMapper.updateEntity(post, postEntity);
            PostEntity saved = postRepository.save(postEntity);
            return postMapper.fromEntity(saved);
        });
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

}
