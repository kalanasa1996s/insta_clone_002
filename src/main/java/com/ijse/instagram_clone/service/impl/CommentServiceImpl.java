package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.dto.CommentDTO;
import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.CommentRepository;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.CommentService;
import com.ijse.instagram_clone.util.CustomException;
import com.ijse.instagram_clone.util.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addComment(String comment, long postId, String token) {

        String email = TokenHandler.getEmailFromToken(token);
        User user = userRepository.findUserByEmail(email);

        Post post = postRepository.findPostById(postId);
        if (post == null) throw new CustomException(404, "No Post found for given ID");

        Comment newComment = new Comment(comment, LocalDateTime.now(), post, user);

        commentRepository.save(newComment);
    }

    @Override
    public List<CommentDTO> getCommentList(long postId) {

        List<CommentDTO> commentDTOList = new ArrayList<>();

        List<Comment> comments = commentRepository.findCommentsByPost_Id(postId);

        if (comments != null && comments.size() > 0) {
            commentDTOList = comments.stream().map(comment ->
                    new CommentDTO(comment.getId(), comment.getComment(), comment.getCommentTime(),
                            comment.getUser().getUid(), comment.getUser().getName())
            ).collect(Collectors.toList());
        }
        return commentDTOList;
    }
}
