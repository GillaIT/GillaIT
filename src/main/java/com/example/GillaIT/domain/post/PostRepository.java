package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<Post> findAll();
    void save(Post post);
    Optional<Post> findById(Long id);
}
