package com.ijse.instagram_clone.controller;


import com.ijse.instagram_clone.dto.CommonDTO;
import com.ijse.instagram_clone.dto.PostDTO;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.service.PostService;
import com.ijse.instagram_clone.service.impl.PostServiceImpl;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")

public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody PostDTO post, @RequestHeader("Authorization") String token) {
        try {
            postService.addPost(post, token);
            return ResponseEntity.ok(new CommonDTO<>(true, "Post added successfully"));
        } catch (
                CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllPost(Pageable page) {
        try {
            Page<PostDTO> allPosts = postService.getAllPost(page);
            return ResponseEntity.ok(new CommonDTO<>(true, allPosts));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @GetMapping("/find-id/{id}")
    public ResponseEntity getSinglePost(@PathVariable(value = "id") long id) {
        try {
            PostDTO singlePost = postService.getSinglePost(id);
            return ResponseEntity.ok(new CommonDTO<>(true, singlePost));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

}
