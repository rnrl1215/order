package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.domain.Order;
import com.barogo.order.exception.CustomException;
import com.barogo.order.fixture.MemberFixture;
import com.barogo.order.fixture.OrderFixture;
import com.barogo.order.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
         LocalDateTime from = LocalDateTime.of(2022,12,10, 0,0,0);
         LocalDateTime to = LocalDateTime.of(2022,12,13,23,59,59);
         orderService.checkMaximumPeriod(from, to);
     }

     @Test
     void fail() {
         LocalDateTime from = LocalDateTime.of(2022,12,10,0,0,0);
         LocalDateTime to = LocalDateTime.of(2022,12,14,23,59,59);
         Assertions.assertThatThrownBy(() -> orderService.checkMaximumPeriod(from, to))
                 .isInstanceOf(CustomException.class);
     }
    }
}