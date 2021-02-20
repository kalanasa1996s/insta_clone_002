package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.dto.CommentDTO;
import com.ijse.instagram_clone.dto.CommonDTO;
import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.service.CommentService;
import com.ijse.instagram_clone.service.impl.CommentServiceImpl;
import com.ijse.instagram_clone.service.impl.ReactServiceImpl;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/add/{id}")
    public ResponseEntity addComment(@RequestParam("text") String text, @PathVariable(value = "id") long postId, @RequestHeader("Authorization") String token) {
        try {
            commentService.addComment(text, postId, token);
            return ResponseEntity.ok(new CommonDTO<>(true, "Comment added successfully"));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity getAll(@PathVariable(value = "id") long postId) {
        try {
            List<CommentDTO> commentList = commentService.getCommentList(postId);
            return ResponseEntity.ok(new CommonDTO<>(true, commentList));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }


}
