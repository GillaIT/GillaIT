package com.example.GillaIT.domain.member;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    @Transactional
    public void toggleIsActive(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member != null)
            member.setIs_active(!member.getIs_active());
    }

    @Transactional
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
