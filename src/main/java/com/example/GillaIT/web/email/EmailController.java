package com.example.GillaIT.web.email;

import com.example.GillaIT.domain.email.CodeService;
import com.example.GillaIT.domain.entity.Code;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final CodeService codeService;
    private final EmailService emailService;
    @PostMapping("/email")
    public String mailSend(@RequestParam("email") String email){
        System.out.println("이메일 인증 이메일 :"+email);
        String code = EmailService.joinEmail(email);
        Code codeObj = new Code(email, code);
        cod(email, code)
        codeService.save(code);
        return EmailService.joinEmail(email);
    }

    @PostMapping("/mailAuth")
    public String AuthCheck(@RequestParam("code") String inputCode, @RequestParam("email") String email){

        Boolean Checked= false;
        Optional<Code> value = CodeService.findCodeByEmail(email);
        Code codeValue = value.get();
        String code = codeValue.getCode();

        if(Objects.equals(code, inputCode)) {
            Checked = true;
        }

        if(Checked){
            return "ok";
        }
        else{
            throw new NullPointerException("인증에서 뭔가 에러가 났어");
        }
    }
}
