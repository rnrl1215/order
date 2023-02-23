package com.barogo.order.exception;

import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.MemberSignupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity custom(CustomException e) {
        return CustomResponseEntity.<MemberSignupRequest>createCustomResponseEntity(null, e.getErrorMessage(), e.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity custom(HttpMessageNotReadableException e) {
        return CustomResponseEntity.<MemberSignupRequest>createCustomResponseEntity(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
