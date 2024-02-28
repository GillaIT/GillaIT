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
        // 테스트 데이터
        Post post = new Post();
        post.setId(sequence);
        post.setTitle("hello");
        post.setContent("test content");
        post.setRecruitDate(new int[] {3, 5});
        post.setUserId(4);
        store.add(post);

        return store;
    }
}
