package com.example.GillaIT.web.email;

import com.example.GillaIT.domain.email.EmailSendService;
import com.example.GillaIT.dtos.EmailCheckDto;
import com.example.GillaIT.dtos.EmailRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailSendService emailSendService;

    // Send Email: 인증번호 전송 버튼 click
    @PostMapping("/email")
    public String mailSend(@RequestBody @Valid EmailRequestDto emailDto) {
        System.out.println("이메일 인증 요청" + emailDto.getEmail());
        return emailSendService.joinEmail(emailDto.getEmail());
    }

    // Email Auth: 인증번호 입력 후 인증 버튼 click
    @PostMapping("/emailAuth")
    public String authCheck(@RequestBody @Valid EmailCheckDto emailCheckDto) {
        Boolean checked = emailSendService.checkAuthNum(emailCheckDto.getEmail(), emailCheckDto.getAuthNum());
        if (checked) {
            return "ok";
        }
        else {
            // 에러 처리는 안 할래 -.-
            throw new NullPointerException("우와 ~ 잘못됨");
        }

    }


}
