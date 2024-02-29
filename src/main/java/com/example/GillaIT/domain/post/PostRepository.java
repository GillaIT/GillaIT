package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;
import com.example.GillaIT.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
}
