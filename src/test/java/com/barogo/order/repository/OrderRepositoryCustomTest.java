package com.barogo.order.repository;

import com.barogo.order.config.TestConfig;
import com.barogo.order.domain.Member;
import com.barogo.order.domain.Order;
import com.barogo.order.fixture.MemberFixture;
import com.barogo.order.fixture.OrderFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@Import({TestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryCustomTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired MemberRepository memberRepository;

    @BeforeEach
    void init() {
        Order order = OrderFixture.order0();
        Member member = MemberFixture.member0();
        member.addOrder(order);
        memberRepository.save(member);
    }

    @Test
    void test () {
        List<Order> foundOrder = orderRepository.findByUserIdAndPeriod("test0", LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(2));
        Assertions.assertThat(foundOrder.size()).isEqualTo(1);
    }
}