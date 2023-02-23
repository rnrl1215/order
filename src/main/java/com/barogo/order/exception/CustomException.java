package com.barogo.order.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {
    public CustomException(String messge) {
        super(messge);
    }

    abstract HttpStatus getHttpStatus();
    abstract String getErrorMessage();
}
