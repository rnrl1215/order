package com.barogo.order.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MemberLoginResponse(@NonNull String id, @NonNull String jwtToken) {
}
