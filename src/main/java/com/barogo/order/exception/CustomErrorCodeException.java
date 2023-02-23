package com.barogo.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomErrorCodeException extends CustomException {
    private final ErrorCode errorCode;

    public CustomErrorCodeException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorCode.getErrorMessage();
    }

    @Override
    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
