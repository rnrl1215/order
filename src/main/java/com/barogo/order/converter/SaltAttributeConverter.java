package com.barogo.order.converter;

import jakarta.persistence.AttributeConverter;

import java.util.Base64;

public class SaltAttributeConverter implements AttributeConverter<byte[], String> {

    @Override
    public String convertToDatabaseColumn(byte[] attribute) {
         return Base64.getEncoder().encodeToString(attribute);
    }

    @Override
    public byte[] convertToEntityAttribute(String dbData) {
        return Base64.getDecoder().decode(dbData);
    }
}
