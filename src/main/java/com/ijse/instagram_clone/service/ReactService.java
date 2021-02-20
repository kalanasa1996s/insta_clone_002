package com.ijse.instagram_clone.service;

import com.ijse.instagram_clone.dto.ReactDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactService {

    void addReact(int reactType, long postId, String token);

    List<ReactDTO> getReactList(long postId);
}
