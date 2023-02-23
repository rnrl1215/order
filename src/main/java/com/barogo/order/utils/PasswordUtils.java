package com.barogo.order.utils;

import org.springframework.util.StringUtils;

public class PasswordUtils {
    public static boolean checkPassword(String password) {
        int constraintConditionCount = 0;
        boolean isSafePassword = false;
        if (!StringUtils.hasText(password)) {
            isSafePassword = false;
        }
        if (containsUpperCase(password)) {
            constraintConditionCount++;
        }
        if (containsLowerCase(password)) {
            constraintConditionCount++;
        }
        if (containsNumber(password)) {
            constraintConditionCount++;
        }
        if (containsSpecialCharacters(password)) {
            constraintConditionCount++;
        }
        if (constraintConditionCount >= 3) {
            isSafePassword = true;
        }
        return isSafePassword;
    }

    public static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean containsNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean containsSpecialCharacters(String password) {
        return password.matches(".*[^a-zA-Z0-9\\\\s].*");
    }

}
