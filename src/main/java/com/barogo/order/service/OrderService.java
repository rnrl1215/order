package com.barogo.order.service;

import com.barogo.order.exception.CustomErrorCodeException;
import com.barogo.order.exception.CustomException;
import com.barogo.order.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import static com.barogo.order.constants.OrderConstant.MAX_SEARCH_PERIOD;
import static com.barogo.order.exception.ErrorCode.MAXIMUM_LOOKUP_PERIOD_EXCEEDED;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OrderService {
    private final MemberRepository memberRepository;

    public void getOrdersByPeriod(String userId, LocalDate from, LocalDate to) {
        checkMaximumPeriod(from, to);
        memberRepository.findById(userId);
    }

    public void checkMaximumPeriod(LocalDate from, LocalDate to) throws CustomException {
        Period between = Period.between(from, to);
        if (between.getDays() > MAX_SEARCH_PERIOD) {
            throw new CustomErrorCodeException(MAXIMUM_LOOKUP_PERIOD_EXCEEDED);
        }
    }
}
