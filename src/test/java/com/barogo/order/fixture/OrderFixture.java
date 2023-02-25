package com.barogo.order.fixture;

import com.barogo.order.domain.Address;
import com.barogo.order.domain.Delivery;
import com.barogo.order.domain.Member;
import com.barogo.order.domain.Order;
import org.aspectj.weaver.ast.Or;

public class OrderFixture {
    public static Order order0() {
        Delivery delivery = Delivery.createDelivery();
        Address address = new Address("test0");
        return Order.createOrder("product0", address, delivery);
    }
}
