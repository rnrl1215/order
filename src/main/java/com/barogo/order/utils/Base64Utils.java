package com.barogo.order.utils;

import com.barogo.order.exception.CustomCommonException;
import com.barogo.order.exception.CustomErrorCodeException;
import com.barogo.order.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import static com.barogo.order.exception.ErrorCode.FAIL_CONVERT_BASE64;

public class Base64Utils {
    public static <T> String convertObjectToBase64String (T object) throws CustomException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)){
                oos.writeObject(object);
                byte[] bytes = baos.toByteArray();
                return Base64.getEncoder().encodeToString(bytes);
            } catch (Exception e) {
               throw new CustomCommonException(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new CustomCommonException(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static String convertByteArrayToString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] convertStringToByteArray(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
