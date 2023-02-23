package com.barogo.order.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MemberLoginRequest(@NonNull String id, @NonNull String password) {
}
