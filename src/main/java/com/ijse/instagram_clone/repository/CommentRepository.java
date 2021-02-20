package com.ijse.instagram_clone.repository;

import com.ijse.instagram_clone.entity.Comment;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByPost_Id(long postId);

    Comment findCommentByPostAndUser(Post post, User user);
}
