package com.example.GillaIT.domain.email;

import com.example.GillaIT.domain.entity.Code;
import com.example.GillaIT.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodeRepository extends JpaRepository<Code, Long> {

    default Optional<Code> findByEmail(String email){
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

}
