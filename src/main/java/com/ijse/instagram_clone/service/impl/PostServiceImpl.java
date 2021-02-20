package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.dto.PostDTO;
import com.ijse.instagram_clone.dto.UserDTO;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.CommentService;
import com.ijse.instagram_clone.service.PostService;
import com.ijse.instagram_clone.service.ReactService;
import com.ijse.instagram_clone.util.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReactService reactService;

    @Override
    public Page<PostDTO> getAllPost(Pageable page) {
        return postRepository.findAll(page).map(this::getPostDTOFromPost);
    }

    @Override
    public void addPost(PostDTO postDetails, String token) {
        String email = TokenHandler.getEmailFromToken(token);
        User user = userRepository.findUserByEmail(email);

        Post post = new Post();
        post.setImgUrl(postDetails.getImgURL());
        post.setText(postDetails.getText());
        post.setDateTime(LocalDateTime.now());
        post.setUser(user);

        postRepository.save(post);
    }


    @Override
    public PostDTO getSinglePost(long id) {
        return getPostDTOFromPost(postRepository.findPostById(id));
    }

    private PostDTO getPostDTOFromPost(Post post) {
        User user = post.getUser();
        return new PostDTO(
                post.getId(),
                post.getImgUrl(),
                post.getText(),
                new UserDTO(user.getUid(), user.getName(), user.getEmail(), null),
                post.getDateTime(),
                commentService.getCommentList(post.getId()),
                reactService.getReactList(post.getId())
        );
    }
}
