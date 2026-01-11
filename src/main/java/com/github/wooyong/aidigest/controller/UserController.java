package com.github.wooyong.aidigest.controller;

import com.github.wooyong.aidigest.config.LoginUser;
import com.github.wooyong.aidigest.dto.UserInfoResponse;
import com.github.wooyong.aidigest.dto.common.CommonResponse;
import com.github.wooyong.aidigest.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    @GetMapping("/me")
    public ResponseEntity<CommonResponse<UserInfoResponse>> getMyInfo(@LoginUser User user) {
        log.info("Get my info request received for user: {}", user.getEmail());

        return ResponseEntity.ok(CommonResponse.success(UserInfoResponse.fromEntity(user)));
    }
}
