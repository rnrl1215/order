package com.barogo.order.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PasswordUtilsTest {

    @Nested
    @DisplayName("소문자 포함 체크")
    class CheckLowerCaseTest {
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
    class CheckUpperCaseTest {
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
    class CheckNumberTest {
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
    class CheckSpecialCharactersTest {
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

    @Nested
    @DisplayName("패스워드 체크")
    class CheckPasswordTest {
        @Test
        void success() {
            // given
            String password = "Abcd@fghi12LMnop";

            // when
            boolean isOk = PasswordUtils.checkPasswordPattern(password);

            // then
            Assertions.assertThat(isOk).isTrue();
        }

        @Test
        void fail() {
            // given
            String password = "AbcdfghiLMnop";

            // when
            boolean isFalse = PasswordUtils.checkPasswordPattern(password);

            // then
            Assertions.assertThat(isFalse).isFalse();
        }
    }

    @Test
    void encryptPassword() {
        // given
        byte[] salt = {22, 125, 17, 127, 80, 109, -108, -37, 108, 96, -6, -100, 38, -62, 0, -11};

        // when
        String test = PasswordUtils.getSecurePassword("test", salt);


        // then
        Assertions.assertThat(test).isEqualTo("3ccf8134609130c0bae13641e318066498b9080bae1459ce53bbbee35bf7940f");
    }
}