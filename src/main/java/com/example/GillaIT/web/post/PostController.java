package com.example.GillaIT.web.post;

import com.example.GillaIT.domain.entity.Post;
import com.example.GillaIT.domain.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/create")
    public String postCreate(@ModelAttribute("post") Post post) {
        return "post/postCreate";
    }

    @PostMapping("")
    public String postCreateProcess(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/detail/{postId}")
    public String postDetail(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    @DeleteMapping("")
    public String postDeleteProcess(@RequestParam("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }
}
