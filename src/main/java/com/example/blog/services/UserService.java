package com.example.blog.services;

import com.example.blog.models.User;
import com.example.blog.models.request.UserCreateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

/**
 * @author smustafov
 */
public interface UserService extends UserDetailsService {

    Optional<User> findByUsername(String username);

    User create(UserCreateRequest createRequest);

}
