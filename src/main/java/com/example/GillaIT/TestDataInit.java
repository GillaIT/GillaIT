package com.example.GillaIT;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setPassword("testtest!");
        member.setGroup_name("테스터");
        member.setIs_admin(false);
        member.setIs_active(false);

        memberRepository.save(member);

        Member member2 = new Member();
        member2.setEmail("123@gmail.com");
        member2.setPassword("12345678");
        member2.setGroup_name("123");
        member2.setIs_admin(true);
        member2.setIs_active(true);

        memberRepository.save(member2);
    }
}
