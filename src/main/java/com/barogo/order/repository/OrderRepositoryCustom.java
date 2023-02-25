package com.barogo.order.repository;

import com.barogo.order.domain.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> findByUserIdAndPeriod(String userId, LocalDateTime from, LocalDateTime to);
}
