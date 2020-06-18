package com.example.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author smustafov
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/post").fullyAuthenticated()
                .antMatchers(HttpMethod.POST, "/post/edit").fullyAuthenticated()
                .antMatchers(HttpMethod.GET, "/post/delete").fullyAuthenticated()
                .anyRequest().permitAll();
    }
}
