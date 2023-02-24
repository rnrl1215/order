package com.barogo.order.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Address {
    private String address;
}
