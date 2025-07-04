package com.mdxq.backend.service;

import com.mdxq.backend.dto.PostCreateRequest;
import com.mdxq.backend.dto.PostUpdateRequest;
import com.mdxq.backend.dto.PostDTO;
import java.util.List;

public interface PostService {
    Long createPost(Long userId, PostCreateRequest req);
    void updatePost(Long userId, PostUpdateRequest req);
    void deletePost(Long userId, Long postId);
    PostDTO getPost(Long id);
    List<PostDTO> getAllPosts();
    List<PostDTO> getPostsByUserId(Long userId);
}