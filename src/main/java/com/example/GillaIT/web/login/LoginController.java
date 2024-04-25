package com.example.GillaIT.web.login;

import com.example.GillaIT.domain.login.LoginService;
import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, HttpServletRequest request, Model model) {
        Member member = loginService.login(loginForm.getEmail(), loginForm.getPassword());

        if (member == null) {
            return "login/login";
        }

        if (!member.getIs_active()) {
            model.addAttribute("message", "아직 승인되지 않은 계정입니다.");
            return "message/message";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}
