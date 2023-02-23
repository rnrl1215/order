package com.barogo.order.utils;

import com.barogo.order.domain.Member;
import com.barogo.order.exception.CustomCommonException;
import com.barogo.order.exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilsTest {

    @Test
    void createToken() {
        Member build = Member.builder()
                .name("name")
                .id("id")
                .password("Test")
                .build();

        String result = JWTUtils.generateJWTToken(build);
        Assertions.assertThat(result).isNotNull();
    }
}