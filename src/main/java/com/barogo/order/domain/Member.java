package com.barogo.order.domain;

import com.barogo.order.converter.SaltAttributeConverter;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
@ToString
public class Member implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false, length = 10)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "salt", nullable = false, columnDefinition = "TEXT")
    @Convert(converter = SaltAttributeConverter.class)
    private byte[] salt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setMember(this);
    }

    @Builder
    public Member(String id, String name, String password, byte[] salt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
    }
}
