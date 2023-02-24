package com.barogo.order.repository;

import com.barogo.order.domain.Order;
import com.barogo.order.domain.QMember;
import com.barogo.order.domain.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Order> findByUserIdAndPeriod(String userId, LocalDateTime from, LocalDateTime to) {
        QOrder order = QOrder.order;
        QMember member = QMember.member;

        return jpaQueryFactory.from(order)
                .select(order)
                .innerJoin(order.member, member)
                .where(
                        member.id.eq(userId)
                                .and(order.createdAt.between(from, to))
                )
                .fetch();
    }
}
