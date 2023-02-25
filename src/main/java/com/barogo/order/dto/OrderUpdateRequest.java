package com.barogo.order.dto;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record OrderUpdateRequest(@NonNull String address) {
}
