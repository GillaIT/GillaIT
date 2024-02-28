package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
}
