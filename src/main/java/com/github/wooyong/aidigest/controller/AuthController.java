package com.github.wooyong.aidigest.controller;

import com.github.wooyong.aidigest.dto.LoginRequest;
import com.github.wooyong.aidigest.dto.SignupRequest;
import com.github.wooyong.aidigest.entity.User;
import com.github.wooyong.aidigest.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        log.info("Signup request received: {}", signupRequest.getEmail());
        User user = authService.signup(signupRequest.getEmail(),
                signupRequest.getPassword(),
                signupRequest.getName());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        authService.logout(session);
        return ResponseEntity.ok().build();
    }
}
