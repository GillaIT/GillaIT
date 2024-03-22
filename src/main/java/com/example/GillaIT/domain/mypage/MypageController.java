package com.example.GillaIT.domain.mypage;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@Slf4j
public class MypageController {

    @GetMapping("")
    public String getMyPage(Model model, HttpServletRequest request){
        log.info("getMyPage 호출됨");


        HttpSession session = request.getSession(false);
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        model.addAttribute("member", member);


        log.info("member 객체 ={}", member);

        return "mypage/mypage";
    }
}
