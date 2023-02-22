package com.barogo.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorCode {
    INVALID_PASSWORD_PATTERN(BAD_REQUEST, "비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상 또는 12자리 이상의 문자열로 생성해야 합니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
