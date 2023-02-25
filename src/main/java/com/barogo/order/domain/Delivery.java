package com.barogo.order.domain;

import com.barogo.order.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "delivery")
@ToString
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status = DeliveryStatus.NONE;

    @CreationTimestamp
    @Column(name = "delivered_at", nullable = false)
    private LocalDateTime deliveredAt;

    public void setOrder(Order order) {
        this.order = order;
    }

    public static Delivery createDelivery() {
        return new Delivery();
    }
}
