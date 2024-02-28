package com.example.GillaIT.web.email;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @PostMapping("/email")
    public String mailSend(@RequestParam("email") String email){
        System.out.println("이메일 인증 이메일 :"+email);
        return EmailService.joinEmail(email);
    }

    @PostMapping("/mailAuth")
    public String AuthCheck(@RequestParam("code") String code, @RequestParam("email") String email){

        Boolean Checked=EmailService.CheckAuthNum(email, code);
        if(Checked){
            return "ok";
        }
        else{
            throw new NullPointerException("인증에서 뭔가 에러가 났어");
        }
    }
}
