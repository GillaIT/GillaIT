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
        member.setEmail("test");
        member.setPassword("test!");
        member.setGroup_name("테스터");

        memberRepository.save(member);
    }
}
