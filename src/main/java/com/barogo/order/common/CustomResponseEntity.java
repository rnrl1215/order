package com.barogo.order.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseEntity<T> {
    public T data;
    public String message;
    public int statusCode;

    private CustomResponseEntity(T data, String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static <T> ResponseEntity createCustomResponseEntity(T data, String message, HttpStatus status) {
        CustomResponseEntity<T> customResponseEntity = new CustomResponseEntity<T>(data, message, status.value());
        return new ResponseEntity<CustomResponseEntity>(customResponseEntity, status);
    }

    public static <T> ResponseEntity createCustomResponseEntity(String message, HttpStatus status) {
        CustomResponseEntity<T> customResponseEntity = new CustomResponseEntity<T>(null, message, status.value());
        return new ResponseEntity<CustomResponseEntity>(customResponseEntity, status);
    }
}
