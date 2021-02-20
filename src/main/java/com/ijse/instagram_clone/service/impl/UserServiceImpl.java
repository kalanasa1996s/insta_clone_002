package com.ijse.instagram_clone.service.impl;

import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.service.UserService;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {

//        return userRepository.findAll( ).stream( ).map(this::addUser).collect(Collectors.toList( ));

        return userRepository.findAll();
    }


    @Override
    public void addUser(User user) {
        User usr = userRepository.findUserByEmail(user.getEmail());

        if (usr != null) throw new CustomException(403, "We found another customer for this telephone number");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }


    @Override
    public User findUser(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(null);
            return user;
        } else {
            throw new CustomException("No user found for this UID");
        }
    }


}
