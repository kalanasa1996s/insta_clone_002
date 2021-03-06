package com.ijse.instagram_clone.repository;

import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactRepository extends JpaRepository<React, Long> {

    List<React> findReactsByPost_Id(long postId);

    React findReactByUserAndPost(User user, Post post);
}
