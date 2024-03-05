package com.example.GillaIT.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @Test
    void is_active토글() {
        Member member = new Member();
        member.setEmail("test@test.com");
        member.setPassword("password");

        memberRepository.save(member);

        memberService.toggleIsActive(member.getId());
        assertThat(member.getIs_active()).isEqualTo(true);

        memberService.toggleIsActive(member.getId());
        assertThat(member.getIs_active()).isEqualTo(false);

    }


}