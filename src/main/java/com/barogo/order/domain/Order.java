package com.barogo.order.domain;

import com.barogo.order.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders")
@ToString
public class Order extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @CreationTimestamp
    @Column(name = "order_at", nullable = false)
    private LocalDateTime orderAt;

    // TODO: product_item 을 만들어 맵핑
    @Column(name = "product_name")
    private String productName;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;

    public void setMember(Member member) {
        this.member = member;
    }

    @Builder
    public Order(OrderStatus orderStatus, String productName, Address address, Delivery delivery) {
        this.orderStatus = orderStatus;
        this.productName = productName;
        this.address = address;
        this.delivery = delivery;
    }

    public static Order createOrder(String productName, Address address, Delivery delivery) {
        Order order = Order.builder().productName(productName)
                .orderStatus(OrderStatus.READY)
                .delivery(delivery)
                .address(address)
                .build();

        delivery.setOrder(order);

        return order;
    }

    public void updateStatusToReady() {
        this.orderStatus = OrderStatus.READY;
    }

    public void updateStatusToCancel() {
        this.orderStatus = OrderStatus.CANCEL;
    }

    public void updateStatusToDone() {
        this.orderStatus = OrderStatus.DONE;
    }

    public void updateAddress(String address) {
        this.address = new Address(address);
    }
}
