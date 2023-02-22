package com.barogo.order.exception;

import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.MemberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity custom(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        return CustomResponseEntity.<MemberRequest>createCustomResponseEntity(null, errorCode.getErrorMessage(), errorCode.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity custom(HttpMessageNotReadableException e) {
        return CustomResponseEntity.<MemberRequest>createCustomResponseEntity(null, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
