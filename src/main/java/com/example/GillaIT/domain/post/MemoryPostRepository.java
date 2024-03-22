package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryPostRepository {
    private static List<Post> store = new ArrayList<>();
    private static Long sequence = 0L;

    public List<Post> findAll() {
        return store;
    }

    public void save(Post post) {
        post.setId(sequence++);
        store.add(post);
    }

    public Optional<Post> findById(Long id) {
        return store.stream().filter(post -> post.getId().equals(id)).findAny();
    }
}
