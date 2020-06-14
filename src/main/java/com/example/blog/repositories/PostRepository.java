package com.example.blog.repositories;

import com.example.blog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author smustafov
 */
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
