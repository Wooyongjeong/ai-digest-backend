package com.github.wooyong.aidigest.dto;

import com.github.wooyong.aidigest.entity.User;
import lombok.Data;

@Data
public class UserInfoResponse {
    private Long id;
    private String email;
    private String name;

    public static UserInfoResponse fromEntity(User user) {
        UserInfoResponse response = new UserInfoResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        return response;
    }
}
