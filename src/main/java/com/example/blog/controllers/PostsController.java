package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String getPost(@RequestParam(required = false) Long id,
                          @RequestParam(defaultValue = "preview") String mode, Model model) {
        Post post;
        if (id == null) {
            post = new Post();
            mode = "create";
        } else {
            post = postService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        model.addAttribute("post", post);
        model.addAttribute("mode", mode);

        return "post";
    }

    @PostMapping
    public String createPost(@Valid Post post, Errors errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "post";
        }

        Post created = postService.create(post);
        LOGGER.info("Created: {}", created);

        redirectAttributes.addAttribute("id", created.getId());
        return "redirect:/post";
    }

}
