package com.mdxq.backend.controller;

import com.mdxq.backend.dto.PostCreateRequest;
import com.mdxq.backend.dto.PostUpdateRequest;
import com.mdxq.backend.dto.PostDTO;
import com.mdxq.backend.service.PostService;
import com.mdxq.backend.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    // 发布帖子
    @PostMapping("/create")
    public Long create(@RequestBody PostCreateRequest req, HttpServletRequest request) {
        String token = getToken(request);
        Long userId = JwtUtil.getUserId(token);
        return postService.createPost(userId, req);
    }

    // 编辑帖子
    @PostMapping("/update")
    public String update(@RequestBody PostUpdateRequest req, HttpServletRequest request) {
        String token = getToken(request);
        Long userId = JwtUtil.getUserId(token);
        postService.updatePost(userId, req);
        return "ok";
    }

    // 删除帖子
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpServletRequest request) {
        String token = getToken(request);
        Long userId = JwtUtil.getUserId(token);
        postService.deletePost(userId, id);
        return "ok";
    }

    // 获取帖子详情
    @GetMapping("/{id}")
    public PostDTO get(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // 获取所有帖子
    @GetMapping("/all")
    public List<PostDTO> all() {
        return postService.getAllPosts();
    }

    // 获取自己的帖子
    @GetMapping("/my")
    public List<PostDTO> my(HttpServletRequest request) {
        String token = getToken(request);
        Long userId = JwtUtil.getUserId(token);
        return postService.getPostsByUserId(userId);
    }

    private String getToken(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        return auth != null && auth.startsWith("Bearer ") ? auth.substring(7) : null;
    }
}