package com.barogo.order.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PasswordInfo {
    String encryptedPassword;
    byte [] salt;
}
