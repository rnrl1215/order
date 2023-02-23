package com.barogo.order.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {

    @Nested
    @DisplayName("소문자 포함 체크")
    class CheckLowerCase {
        @Test
        void success() {
            // given
            String password = "AbcD";

            // when
            boolean isOk = PasswordUtils.containsLowerCase(password);

            // then
            Assertions.assertThat(isOk).isTrue();
        }
        @Test
        void fail() {
            // given
            String password = "AD";

            // when
            boolean isFalse = PasswordUtils.containsLowerCase(password);

            // then
            Assertions.assertThat(isFalse).isFalse();
        }
    }


    @Nested
    @DisplayName("대문자 포함 체크")
    class CheckUpperCase {
        @Test
        void success() {
            // given
            String password = "AbcD";

            // when
            boolean isOk = PasswordUtils.containsUpperCase(password);

            // then
            Assertions.assertThat(isOk).isTrue();
        }
        @Test
        void fail() {
            // given
            String password = "bc";

            // when
            boolean isFalse = PasswordUtils.containsUpperCase(password);

            // then
            Assertions.assertThat(isFalse).isFalse();
        }
    }

    @Nested
    @DisplayName("숫자 포함 체크")
    class CheckNumber {
        @Test
        void success() {
            // given
            String password = "2AD";

            // when
            boolean isOk = PasswordUtils.containsNumber(password);

            // then
            Assertions.assertThat(isOk).isTrue();
        }
        @Test
        void fail() {
            // given
            String password = "bc";

            // when
            boolean isFalse = PasswordUtils.containsNumber(password);

            // then
            Assertions.assertThat(isFalse).isFalse();
        }
    }


    @Nested
    @DisplayName("툭스 문자 포함 체크")
    class checkSpecialCharacters {
        @Test
        void success() {
            // given
            String password = "2A@D";

            // when
            boolean isOk = PasswordUtils.containsSpecialCharacters(password);

            // then
            Assertions.assertThat(isOk).isTrue();
        }

        @Test
        void fail() {
            // given
            String password = "bc";

            // when
            boolean isFalse = PasswordUtils.containsSpecialCharacters(password);

            // then
            Assertions.assertThat(isFalse).isFalse();
        }
    }
}