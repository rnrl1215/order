package com.barogo.order.service;

import com.barogo.order.domain.Order;
import com.barogo.order.dto.DeliveryResponse;
import com.barogo.order.dto.OrderUpdateRequest;
import com.barogo.order.exception.CustomErrorCodeException;
import com.barogo.order.exception.CustomException;
import com.barogo.order.repository.MemberRepository;
import com.barogo.order.repository.OrderRepository;
import com.barogo.order.repository.OrderRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static com.barogo.order.constants.OrderConstant.MAX_SEARCH_PERIOD;
import static com.barogo.order.exception.ErrorCode.MAXIMUM_LOOKUP_PERIOD_EXCEEDED;
import static com.barogo.order.exception.ErrorCode.NOT_EXIST_ORDER;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepositoryCustom;

    @Transactional
    public Order updateOrder(Long orderId, OrderUpdateRequest orderUpdateRequest) throws CustomException{
        Order order = findOrderById(orderId);
        order.updateAddress(orderUpdateRequest.address());
        return order;
    }

    private Order findOrderById(Long orderId) {
        Order foundOrder = orderRepositoryCustom.findById(orderId)
                .orElseThrow(() -> {
                    throw new CustomErrorCodeException(NOT_EXIST_ORDER);
                });

        return foundOrder;
    }

    public List<DeliveryResponse> getOrdersByPeriod(String userId, LocalDateTime from, LocalDateTime to) {
        checkMaximumPeriod(from, to);
        memberRepository.findById(userId);
        List<Order> foundOrders = orderRepositoryCustom.findByUserIdAndPeriod(userId, from, to);
        return foundOrders.stream()
                .map(
                        i -> {
                            return DeliveryResponse.builder()
                                    .name(i.getMember().getName())
                                    .id(i.getMember().getId())
                                    .deliveredAt(i.getDelivery().getDeliveredAt())
                                    .address(i.getAddress().getAddress())
                                    .productName(i.getProductName())
                                    .build();
                        }
                ).collect(Collectors.toList());
    }

    public void checkMaximumPeriod(LocalDateTime from, LocalDateTime to) throws CustomException {
        Period between = Period.between(from.toLocalDate(), to.toLocalDate());
        int days = between.getDays();
        if (between.getDays() > MAX_SEARCH_PERIOD) {
            throw new CustomErrorCodeException(MAXIMUM_LOOKUP_PERIOD_EXCEEDED);
        }
    }
}
