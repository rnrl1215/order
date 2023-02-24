package com.barogo.order.dto;


import java.time.LocalDateTime;

public record DeliverySearchRequest(String userId, LocalDateTime from, LocalDateTime to) {
}
