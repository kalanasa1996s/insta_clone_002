package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.dto.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    void addComment(String comment, long postId, String token);

    List<CommentDTO> getCommentList(long postId);

}
