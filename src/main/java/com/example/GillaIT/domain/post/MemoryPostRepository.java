package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryPostRepository implements PostRepository {
    private static List<Post> store = new ArrayList<>();
    private static Long sequence = 0L;

    @Override
    public List<Post> findAll() {
        return store;
    }

    @Override
    public void save(Post post) {
        post.setId(sequence++);
        store.add(post);
    }
}
