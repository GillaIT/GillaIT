package com.example.GillaIT.web.email;

import com.example.GillaIT.domain.email.EmailSendService;
import com.example.GillaIT.dtos.EmailCheckDto;
import com.example.GillaIT.dtos.EmailRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailSendService emailSendService;

    // Send Email: 인증번호 전송 버튼 click
    @PostMapping("/signup/email")
    public Map<String, String> mailSend(@RequestBody @Valid EmailRequestDto emailRequestDto) {
        String code = emailSendService.joinEmail(emailRequestDto.getEmail());
        Map<String, String> response = new HashMap<>();
        response.put("code", code);

        return response;
    }

    // Email Auth: 인증번호 입력 후 인증 버튼 click
    @PostMapping("/signup/emailAuth")
    public String authCheck(@RequestBody @Valid EmailCheckDto emailCheckDto) {
        Boolean checked = emailSendService.checkAuthNum(emailCheckDto.getEmail(), emailCheckDto.getAuthNum());
        if (checked) {
            return "이메일 인증 성공!";
        }
        else {
            throw new NullPointerException("잘못된 인증번호이거나 인증번호가 만료되었습니다.");
        }
    }
}
