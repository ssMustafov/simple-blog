package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author smustafov
 */
@Controller
public class PostsController {

    @GetMapping("/post")
    public String createPost() {
        return "post";
    }

}
