package com.github.wooyong.aidigest.service;

import com.github.wooyong.aidigest.dto.UserInfoResponse;
import com.github.wooyong.aidigest.entity.User;
import com.github.wooyong.aidigest.exception.DuplicateEmailException;
import com.github.wooyong.aidigest.exception.UserNotFoundException;
import com.github.wooyong.aidigest.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserInfoResponse signup(String email, String password, String name) {
        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException();
        }

        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .build();

        userRepository.save(user);
        log.info("User '{}' signed up", email);
        return UserInfoResponse.fromEntity(user);
    }

    public UserInfoResponse login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Spring Security Context에 인증 정보 저장
        // SecurityContextHolder가 자동으로 Session에 저장함
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user, null,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

        SecurityContextHolder.getContext().setAuthentication(authToken);
        log.info("User '{}' logged in", email);
        return UserInfoResponse.fromEntity(user);
    }

    public void logout(HttpSession session) {
        SecurityContextHolder.clearContext();
        session.invalidate();
        log.info("User logged out");
    }
}
