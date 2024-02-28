package com.example.GillaIT.domain.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {

    private final ConcurrentHashMap<Long, Member> repo = new ConcurrentHashMap<>();
    private long count = 0;

    public void save(Member member){
        member.setId(++count);
        member.setIs_active(false);
        member.setIs_admin(false);
        repo.put(member.getId(), member);
        System.out.println(repo.get(count).getId() +", "+ repo.get(count).getEmail());
    }

    public Member find(Long key){
        return repo.get(key);
    }

    public Optional<Member> findByEmail(String email){
        return findAll().stream()
                .filter(m -> m.getEmail().equals(email))
                .findFirst();
    }

    public List<Member> findAll(){
        return new ArrayList<>(repo.values());
    }
}
