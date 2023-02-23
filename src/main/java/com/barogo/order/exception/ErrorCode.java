package com.barogo.order.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    INVALID_PASSWORD(BAD_REQUEST, "비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상 또는 12자리 이상의 문자열로 생성해야 합니다."),
    EXIST_ID(BAD_REQUEST, "이미 존재 하는 아이디 입니다."),
    FAIL_CREATE_PASSWORD(INTERNAL_SERVER_ERROR, "패스워드 암호화 실패."),
    FAIL_CONVERT_BASE64(INTERNAL_SERVER_ERROR, "Base64 컨버팅 실패."),
    FAIL_GENERATE_JWT(INTERNAL_SERVER_ERROR, "JWT 토큰 생성 실패"),
    NOT_EXIST_ID(BAD_REQUEST, "존재하지 않는 아이디 입니다."),
    BAD_CREDENTIALS(BAD_REQUEST, "패스워드가 틀립니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

    ErrorCode(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
