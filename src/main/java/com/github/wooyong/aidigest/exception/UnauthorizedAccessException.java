package com.github.wooyong.aidigest.exception;

public class UnauthorizedAccessException extends BusinessException {
    public UnauthorizedAccessException() {
        super(ErrorCode.LOGIN_REQUIRED);
    }
}
