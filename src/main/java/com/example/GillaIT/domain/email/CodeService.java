package com.example.GillaIT.domain.email;

import com.example.GillaIT.domain.entity.Code;
import com.example.GillaIT.domain.member.Member;
import com.example.GillaIT.web.email.EmailController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeRepository codeRepository;

    public void save(Code code) { codeRepository.save(code); }

    public Optional<Code> findCodeByEmail(String email) {return codeRepository.findByEmail(email);}
}
