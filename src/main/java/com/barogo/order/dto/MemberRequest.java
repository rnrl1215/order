package com.barogo.order.dto;

import lombok.NonNull;

public record MemberRequest(@NonNull String name, @NonNull String password) {
}
