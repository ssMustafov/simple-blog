package com.example.blog.services;

import com.example.blog.entity.UserEntity;
import com.example.blog.models.User;
import com.example.blog.models.UserRole;
import com.example.blog.models.request.UserCreateRequest;
import com.example.blog.repositories.UserRepository;
import com.example.blog.services.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author smustafov
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::fromEntity);
    }

    @Override
    public User create(UserCreateRequest createRequest) {
        createRequest.setPassword(passwordEncoder.encode(createRequest.getPassword()));

        UserEntity userEntity = userMapper.toEntity(createRequest);
        userEntity.setRole(UserRole.USER);
        UserEntity saved = userRepository.save(userEntity);
        return userMapper.fromEntity(saved);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(userMapper::toUserDetailsFromEntity)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
