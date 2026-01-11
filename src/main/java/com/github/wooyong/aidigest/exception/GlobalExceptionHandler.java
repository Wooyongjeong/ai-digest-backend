package com.github.wooyong.aidigest.exception;

import com.github.wooyong.aidigest.dto.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<CommonResponse<?>> handleBusinessException(final BusinessException e) {
        log.error("handleBusinessException: {}", e.getMessage(), e);
        final ErrorCode errorCode = e.getErrorCode();
        final CommonResponse<?> response = CommonResponse.error(errorCode.getCode(), errorCode.getMessage());
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<CommonResponse<?>> handleException(final Exception e) {
        log.error("handleException: {}", e.getMessage(), e);
        final ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        final CommonResponse<?> response = CommonResponse.error(errorCode.getCode(), errorCode.getMessage());
        return new ResponseEntity<>(response, errorCode.getStatus());
    }
}
