package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.dto.CommonDTO;
import com.ijse.instagram_clone.dto.ReactDTO;
import com.ijse.instagram_clone.entity.React;
import com.ijse.instagram_clone.service.ReactService;
import com.ijse.instagram_clone.service.impl.ReactServiceImpl;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/react")
public class ReactController {


    @Autowired
    private ReactService reactService;


    @PostMapping("/add/{id}")
    public ResponseEntity addReact(@RequestParam("reactType") int reactType, @PathVariable(value = "id") long postId, @RequestHeader("Authorization") String token) {
        try {
            reactService.addReact(reactType, postId, token);
            return ResponseEntity.ok(new CommonDTO<>(true, "React added successfully"));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @GetMapping("/all/{id}")
    public ResponseEntity getAll(@PathVariable(value = "id") long postId) {
        try {
            List<ReactDTO> reactList = reactService.getReactList(postId);
            return ResponseEntity.ok(new CommonDTO<>(true, reactList));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

}
