package com.barogo.order.converter;

import com.barogo.order.utils.Base64Utils;
import jakarta.persistence.AttributeConverter;

public class SaltAttributeConverter implements AttributeConverter<byte[], String> {

    @Override
    public String convertToDatabaseColumn(byte[] attribute) {
         return Base64Utils.convertByteArrayToString(attribute);
    }

    @Override
    public byte[] convertToEntityAttribute(String dbData) {
        return Base64Utils.convertStringToByteArray(dbData);
    }
}
