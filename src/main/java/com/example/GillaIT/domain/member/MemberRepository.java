package com.example.GillaIT.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Optional<Member> findByEmail(String email){
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }
}
