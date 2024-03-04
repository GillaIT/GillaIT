package com.example.GillaIT.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemoryMemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void toggleIsActive(Long id) {
        memberRepository.toggleIsActive(id);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
