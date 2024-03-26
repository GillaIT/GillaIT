package com.example.GillaIT.web;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.post.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    private PostService postService;

    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(
            HttpServletRequest request,
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember,
            Model model) {

        model.addAttribute("posts", postService.getPosts());

        // 로그인 했는지 확인 -> 글 작성 버튼 보이게
        HttpSession session = request.getSession();
        if(session != null & session.getAttribute(SessionConst.LOGIN_MEMBER) != null) {
            model.addAttribute("loggedIn", true);
        }
        return "home";
    }
}
