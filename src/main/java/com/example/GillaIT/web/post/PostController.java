package com.example.GillaIT.web.post;

import com.example.GillaIT.domain.entity.Post;
import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.post.ImageService;
import com.example.GillaIT.domain.post.PostService;
import com.example.GillaIT.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/post")
@Slf4j
public class PostController {
    private PostService postService;
    private ImageService imageService;
    public PostController(PostService postService, ImageService imageService) {
        this.postService = postService;
        this.imageService = imageService;
    }

    @GetMapping("/create")
    public String postCreate(@ModelAttribute("post") Post post) {
        return "post/postCreate";
    }

    @PostMapping("")
    public String postCreateProcess(HttpServletRequest request, @ModelAttribute("post") Post post, @RequestPart(value="files") List<MultipartFile> images) {
        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        post.setMember(member);
        postService.savePost(post);
        imageService.savePostImages(post, images);
        return "redirect:/";
    }

    @GetMapping("/detail/{postId}")
    public String postDetail(HttpServletRequest request, @PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        // 로그인 사용자의 작성글인지 확인
        HttpSession session = request.getSession();
        if(post.getMember().equals(session.getAttribute(SessionConst.LOGIN_MEMBER))) { // Member Class에 equals를 overriding 해주어야 한다
            model.addAttribute("writer", true);
        }

        return "post/postDetail";
    }

    @DeleteMapping("")
    public String postDeleteProcess(@RequestParam("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }

    @GetMapping("/update/{postId}")
    public String postUpdate(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "post/postUpdate";
    }

    @PutMapping("")
    public String postUpdateProcess(@ModelAttribute("post") Post post) {
        postService.updatePost(post);
        return "redirect:/";
    }
}
