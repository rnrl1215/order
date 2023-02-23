package com.barogo.order.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record MemberRequest(@NonNull String id, @NonNull String name, @NonNull String password) {
}
