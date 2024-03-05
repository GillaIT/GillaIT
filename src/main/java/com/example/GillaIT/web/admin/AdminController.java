package com.example.GillaIT.web.admin;

import com.example.GillaIT.domain.login.LoginService;
import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.member.MemberService;
import com.example.GillaIT.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {
    private final MemberService memberService;
    private final LoginService loginService;
    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String processLogin(LoginForm loginForm, HttpServletRequest request) {
        Member member = loginService.login(loginForm.getEmail(), loginForm.getPassword());

        if (member ==null) {
            return "redirect:/admin/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        member.setIs_admin(true);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String home(Model model){
        List<Member> users = memberService.findAll();
        model.addAttribute("users", users);
        return "admin/home";
    }

    @PutMapping("/admin/user/toggle/{id}")
    public String toggle(@PathVariable Long id) {
        if (id != null)
            memberService.toggleIsActive(id);
        return "redirect:/admin";
    }


    @DeleteMapping("/admin/user/{id}")
    public String deleteUser(@PathVariable Long id){
        if (id != null)
            memberService.deleteById(id);
        return "redirect:/admin";
    }

}
