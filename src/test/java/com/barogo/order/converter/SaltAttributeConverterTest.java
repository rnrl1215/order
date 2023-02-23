package com.barogo.order.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SaltAttributeConverterTest {

    private final byte[] salt =  {22, 125, 17, 127, 80, 109, -108, -37, 108, 96, -6, -100, 38, -62, 0, -11};
    private final String base64 = "Fn0Rf1BtlNtsYPqcJsIA9Q==";

    @Test
    void convertByteArrayToString() {
        SaltAttributeConverter sac = new SaltAttributeConverter();
        String convertedBase64 = sac.convertToDatabaseColumn(salt);
        assertThat(convertedBase64).isEqualTo(base64);
    }
    @Test
    void convertStringToByteArray() {
        SaltAttributeConverter sac = new SaltAttributeConverter();
        byte[] bytes = sac.convertToEntityAttribute(base64);
        assertThat(bytes).isEqualTo(salt);
    }



}