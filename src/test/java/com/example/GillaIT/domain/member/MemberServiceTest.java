package com.example.GillaIT.domain.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

//    @BeforeEach
//    public void beforeEach() {
//
//        memberRepository = new MemoryMemberRepository();
//        memberService = new MemberService(memberRepository);
//    }


    @Test
    void is_active토글() {
        System.out.println(org.hibernate.Version.getVersionString());
        //given
        Member member = new Member();
        member.setEmail("test@test.com");
        member.setPassword("password");

        //when
        memberRepository.save(member);

        //then
        memberService.toggleIsActive(member.getId());
        assertThat(member.getIs_active()).isEqualTo(true);

        memberService.toggleIsActive(member.getId());
        assertThat(member.getIs_active()).isEqualTo(false);

    }

    @Test
    void 회원삭제() {
        //given
        Member member = new Member();
        member.setEmail("test@test.com");
        member.setPassword("password");

        //when
        memberRepository.save(member);

        //then
        memberService.deleteById(member.getId());
        assertThat(memberRepository.find(member.getId())).isEqualTo(null);
    }


}