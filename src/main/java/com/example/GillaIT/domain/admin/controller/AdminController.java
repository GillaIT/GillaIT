package com.example.GillaIT.domain.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

import static java.rmi.server.LogStream.log;

@Slf4j
@Controller
public class AdminController {

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
        List<String> users = new ArrayList<>();
        for(int i=0; i<10; i++){
            users.add("users"+i);
        }
        model.addAttribute("users", users);
        return "admin/home";
    }


}
