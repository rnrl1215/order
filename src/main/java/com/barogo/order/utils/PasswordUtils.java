package com.barogo.order.utils;

import com.barogo.order.exception.CustomException;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static com.barogo.order.exception.ErrorCode.FAIL_CREATE_PASSWORD;

public class PasswordUtils {
    public static boolean checkPassword(String password) {
        int constraintConditionCount = 0;
        boolean isSafePassword = false;
        if (!StringUtils.hasText(password) || password.length() <= 12) {
            return false;
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

    public static String getSecurePassword(String password, byte[] salt) throws CustomException {
        StringBuilder sb = new StringBuilder();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());

            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new CustomException(FAIL_CREATE_PASSWORD);
        }
        return sb.toString();
    }

    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
