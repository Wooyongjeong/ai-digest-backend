package com.github.wooyong.aidigest.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

    private final boolean success;
    private final T data;
    private final ErrorResponse error;

    private CommonResponse(boolean success, T data, ErrorResponse error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(true, data, null);
    }

    public static CommonResponse<?> error(String code, String message) {
        return new CommonResponse<>(false, null, new ErrorResponse(code, message));
    }
}
