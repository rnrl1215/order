package com.barogo.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomCommonException extends CustomException {
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public CustomCommonException(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
