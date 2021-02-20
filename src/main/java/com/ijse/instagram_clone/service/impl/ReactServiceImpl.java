package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.dto.ReactDTO;
import com.ijse.instagram_clone.entity.Post;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.PostRepository;
import com.ijse.instagram_clone.repository.ReactRepository;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.ReactService;
import com.ijse.instagram_clone.util.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReactServiceImpl implements ReactService {

    @Autowired
    private ReactRepository reactRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addReact(int reactType, long postId, String token) {

        Post post = postRepository.findPostById(postId);
        String email = TokenHandler.getEmailFromToken(token);
        User currentUser = userRepository.findUserByEmail(email);

        React existingReact = reactRepository.findReactByUserAndPost(currentUser, post);

        React newReact;
        if (existingReact == null) newReact = new React(reactType, post, currentUser);
        else {
            newReact = existingReact;
            newReact.setReactType(reactType);
        }

        reactRepository.save(newReact);
    }

    @Override
    public List<ReactDTO> getReactList(long postId) {
        List<ReactDTO> reactDTOList = new ArrayList<>();

        List<React> reacts = reactRepository.findReactsByPost_Id(postId);
        if (reacts != null && reacts.size() > 0) {
            reactDTOList = reacts.stream().map(react ->
                    new ReactDTO(react.getId(), react.getReactType(), react.getUser().getUid(), react.getUser().getName())
            ).collect(Collectors.toList());
        }
        return reactDTOList;
    }
}
