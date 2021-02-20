package com.ijse.instagram_clone.controller;

import com.ijse.instagram_clone.dto.CommonDTO;
import com.ijse.instagram_clone.entity.User;
import com.ijse.instagram_clone.service.impl.UserServiceImpl;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/all")
    public ResponseEntity getAllUsers() {
        try {
            List<User> allUsers = userService.getAllUsers();
            return ResponseEntity.ok(new CommonDTO<>(true, allUsers));
        } catch (
                CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @GetMapping("find/{uid}")
    public ResponseEntity findUser(@PathVariable int uid) {
        try {
            User user = userService.findUser(uid);
            return ResponseEntity.ok(new CommonDTO<>(true, user));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok(new CommonDTO<>(true, "User added successfully"));
        } catch (CustomException ce) {
            return ResponseEntity.ok(new CommonDTO<>(false, ce.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.ok(new CommonDTO<>(false, "Something went wrong"));
        }
    }

}
