package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.dto.MemberRequest;
import com.barogo.order.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    @Test
    void createMember () {
        // given
        MemberRequest mr = new MemberRequest("rnrl1215", "skahn", "tesE@32@#DSAt");

        // when
        Member member = memberService.createMemberAndPassword(mr);

        // then
        Assertions.assertThat(member.getSalt()).isNotNull();
        Assertions.assertThat(member.getPassword()).isNotNull();
    }
}