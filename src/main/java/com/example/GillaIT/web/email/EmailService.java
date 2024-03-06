package com.example.GillaIT.web.email;

import com.example.GillaIT.domain.email.CodeRepository;
import com.example.GillaIT.domain.email.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    private int authNumber;

    // 인증 번호 6자리 생성
    public void makerandomNum() {
        Random random = new Random();
        String randomNum = "";
        for (int i = 0; i < 6; i++) {
            randomNum += Integer.toString(random.nextInt(10));
        }
        authNumber = Integer.parseInt(randomNum);
    }

    // 이메일 전송 세팅
    public String joinEmail(String email) {
        makerandomNum();
        String setFrom = "gillait.official@gmail.com";
        String toMail = email;
        String title = "길라IT 회원 인증 이메일입니다.";
        String content =
                "IT 단체 인증을 위해 단체 메일을 통한 인증 번호 입력이 필요합니다." + 	//html 형식으로 작성 !
                        "<br><br>" +
                        "인증 번호는 " + authNumber + "입니다." +
                        "<br>" +
                        "인증번호를 입력해주세요!";
        mailSend(setFrom, toMail, title, content);
        return Integer.toString(authNumber);
    }

    // 이메일 전송
    public void mailSend(String setFrom, String toMail, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();//JavaMailSender 객체를 사용하여 MimeMessage 객체를 생성
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");//이메일 메시지와 관련된 설정을 수행합니다.
            // true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
            helper.setFrom(setFrom);//이메일의 발신자 주소 설정
            helper.setTo(toMail);//이메일의 수신자 주소 설정
            helper.setSubject(title);//이메일의 제목을 설정
            helper.setText(content,true);//이메일의 내용 설정 두 번째 매개 변수에 true를 설정하여 html 설정으로한다.
            mailSender.send(message);
        } catch (MessagingException e) {//이메일 서버에 연결할 수 없거나, 잘못된 이메일 주소를 사용하거나, 인증 오류가 발생하는 등 오류
            // 이러한 경우 MessagingException이 발생
            e.printStackTrace();//e.printStackTrace()는 예외를 기본 오류 스트림에 출력하는 메서드
        }


    }
}
