package com.barogo.order.controller;

import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.DeliveryResponse;
import com.barogo.order.dto.DeliverySearchRequest;
import com.barogo.order.dto.MemberSignupRequest;
import com.barogo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity getOrders(DeliverySearchRequest deliverySearchRequest) {
        List<DeliveryResponse> ordersByPeriod = orderService.getOrdersByPeriod(deliverySearchRequest.userId(), deliverySearchRequest.from(), deliverySearchRequest.to());
        return CustomResponseEntity.createCustomResponseEntity(ordersByPeriod, "Requested searching order service", HttpStatus.CREATED);
    }
}
