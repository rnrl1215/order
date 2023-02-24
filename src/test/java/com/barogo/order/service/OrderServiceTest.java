package com.barogo.order.service;

import com.barogo.order.exception.CustomException;
import com.barogo.order.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTest {

    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    OrderService orderService;

    @Nested
    @DisplayName("조회기간 체크 테스트")
    class CheckMaximumPeriodTest {
     @Test
     void success() {
         LocalDate from = LocalDate.of(2022,12,10);
         LocalDate to = LocalDate.of(2022,12,13);
         orderService.checkMaximumPeriod(from, to);
     }

     @Test
     void fail() {
         LocalDate from = LocalDate.of(2022,12,10);
         LocalDate to = LocalDate.of(2022,12,14);
         Assertions.assertThatThrownBy(() -> orderService.checkMaximumPeriod(from, to))
                 .isInstanceOf(CustomException.class);
     }
    }
}