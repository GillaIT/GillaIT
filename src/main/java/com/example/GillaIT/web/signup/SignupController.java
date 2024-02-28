package com.example.GillaIT.web.signup;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.signup.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @GetMapping("/signup")
    public String signuppage(@ModelAttribute("member") Member member){
        return "signup/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("member") Member member){
        signupService.register(member);

        return "redirect:/";
    }
}
