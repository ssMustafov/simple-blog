package com.example.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author smustafov
 */
@Configuration
@EnableJpaRepositories("com.example.blog.repositories")
@EnableJpaAuditing
public class PersistenceConfig {
}
