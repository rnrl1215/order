package com.barogo.order.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import static com.barogo.order.constants.JwtConstant.JWT_EXPIRE_PERIOD;

public class JWTUtils {
    public static <T> String generateJWTToken(T object) {
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + JWT_EXPIRE_PERIOD);

        String key = Base64Utils.convertObjectToBase64String(object);

        Claims claims = Jwts.claims().setId(key);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
