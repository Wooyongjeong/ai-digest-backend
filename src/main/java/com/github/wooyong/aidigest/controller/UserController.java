package com.github.wooyong.aidigest.controller;

import com.github.wooyong.aidigest.config.LoginUser;
import com.github.wooyong.aidigest.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    @GetMapping("/me")
    public ResponseEntity<?> getMyInfo(@LoginUser User user) {
        if (user == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        return ResponseEntity.ok(user);
    }
}
