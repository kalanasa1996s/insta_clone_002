package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Page<PostDTO> getAllPost(Pageable page);

    void addPost(PostDTO postDetails, String token);

    PostDTO getSinglePost(long id);


}
