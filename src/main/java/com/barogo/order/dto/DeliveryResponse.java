package com.barogo.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class DeliveryResponse {
    private String id;
    private String name;
    private String address;
    private String productName;
    private LocalDateTime deliveredAt;
}
