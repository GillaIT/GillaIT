package com.example.GillaIT.domain.signup;

import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final MemberRepository memberRepository;

    public void register(Member member){
        member.setIs_admin(false);
        member.setIs_active(false);

        memberRepository.save(member);
    }



}
