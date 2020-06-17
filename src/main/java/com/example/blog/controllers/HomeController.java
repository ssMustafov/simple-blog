package com.example.blog.controllers;

import com.example.blog.services.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author smustafov
 */
@Controller
public class HomeController {

    private final PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") Integer page,
                       @RequestParam(defaultValue = "3") Integer pageSize,
                       Model model) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("posts", postService.findAll(pageRequest));
        return "home";
    }

}
