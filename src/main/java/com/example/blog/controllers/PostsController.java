package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.services.PostService;
import com.example.blog.web.NotificationService;
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

    private final PostService postService;
    private final NotificationService notificationService;

    public PostsController(PostService postService, NotificationService notificationService) {
        this.postService = postService;
        this.notificationService = notificationService;
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
        notificationService.addSuccessMessage("Post created successfully");

        redirectAttributes.addAttribute("id", created.getId());
        return "redirect:/post";
    }

    @PostMapping("/edit")
    public String updatePost(@Valid Post post, Errors errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "post";
        }

        Post updated = postService.update(post.getId(), post)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        notificationService.addSuccessMessage("Post updated successfully");

        redirectAttributes.addAttribute("id", updated.getId());
        return "redirect:/post";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        postService.deleteById(id);
        notificationService.addSuccessMessage("Post deleted successfully");
        return "redirect:/";
    }

}
