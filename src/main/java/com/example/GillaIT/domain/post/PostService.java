package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Transactional
    public void updatePost(Post post) {
        log.info("post 객체={}", post);
        Long postId = post.getId();
        Post prevPost = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + postId));
        postUpdate(post, prevPost);
        postRepository.save(prevPost);
    }

    private static void postUpdate(Post post, Post prevPost) {
        prevPost.setTitle(post.getTitle());
        prevPost.setContent(post.getContent());
        prevPost.setCategory(post.getCategory());
        prevPost.setRecruitDate(post.getRecruitDate());
    }
}
