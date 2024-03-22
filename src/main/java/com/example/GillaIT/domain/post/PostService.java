package com.example.GillaIT.domain.post;

import com.example.GillaIT.domain.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}
