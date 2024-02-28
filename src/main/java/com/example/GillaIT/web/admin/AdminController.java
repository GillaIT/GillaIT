package com.example.GillaIT.web.admin;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.member.MemberRepository;
import com.example.GillaIT.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {
    private final MemberRepository memberRepository;

    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String processLogin(LoginForm form) {
        String email = form.getEmail();
        String password = form.getPassword();

        if ("admin".equals(email) && "password".equals(password)) {
            return "redirect:/admin";
        }
        return "redirect:/admin/login";

    }

    @GetMapping("/admin")
    public String home(Model model){
        List<Member> users = memberRepository.findAll();
        model.addAttribute("users", users);
        return "admin/home";
    }

    @PostMapping("/admin/user/toggle")
    public String toggle(LoginForm loginForm) {
        String email = loginForm.getEmail();
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setIs_active(!member.getIs_active());
            return "redirect:/admin";
        } else {
            // 해당 이메일을 가진 회원을 찾을 수 없는 경우에 대한 처리
            return "redirect:/admin"; // 예시로 리다이렉트 처리
        }
    }


    @PostMapping("/admin/user")
    public String deleteUser(LoginForm loginForm){

        return "redirect:/admin";
    }

}
