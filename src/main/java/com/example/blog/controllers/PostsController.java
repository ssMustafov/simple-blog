package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author smustafov
 */
@Controller
@RequestMapping("/post")
public class PostsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostsController.class);

    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getPost(Model model) {
        model.addAttribute("post", new Post());
        return "post";
    }

    @PostMapping
    public String createPost(@Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return "post";
        }

        Post created = postService.create(post);
        LOGGER.info("Created: {}", created);

        return "redirect:/post";
    }

}
