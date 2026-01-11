package com.github.wooyong.aidigest.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Auth
    LOGIN_REQUIRED("A001", "Login is required.", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND("A002", "User not found.", HttpStatus.NOT_FOUND),
    DUPLICATE_EMAIL("A003", "Email is already in use.", HttpStatus.CONFLICT),
    FORBIDDEN("A004", "You do not have permission to access this resource.", HttpStatus.FORBIDDEN),

    // Subscription
    SUBSCRIPTION_NOT_FOUND("S001", "Subscription not found.", HttpStatus.NOT_FOUND),

    // Common
    INTERNAL_SERVER_ERROR("C001", "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_INPUT_VALUE("C002", "Invalid input value.", HttpStatus.BAD_REQUEST);


    private final String code;
    private final String message;
    private final HttpStatus status;
}
