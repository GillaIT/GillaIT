package com.example.GillaIT.web.signup;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.signup.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
    public String signup(@Valid @ModelAttribute("member") Member member, Errors errors){
        if(errors.hasErrors()) {
            return "signup/signup";
        }

        signupService.register(member);

        return "redirect:/";
    }
}
