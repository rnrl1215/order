package com.barogo.order.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MemberSignupRequest(@NonNull String id, @NonNull String name, @NonNull String password) {
}
