package com.barogo.order.exception;

import org.springframework.http.HttpStatus;

public interface CustomExceptionInterface {
    String getErrorMessage();
    HttpStatus getHttpStatus();
}
