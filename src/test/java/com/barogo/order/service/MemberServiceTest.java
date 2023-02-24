package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.dto.MemberLoginResponse;
import com.barogo.order.dto.MemberSignupRequest;
import com.barogo.order.model.MemberFixture;
import com.barogo.order.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class MemberServiceTest {
    @Mock
    MemberRepository memberRepository;

    @InjectMocks
    MemberService memberService;

    @Test
    void createMember () {
        // given
        MemberSignupRequest mr = new MemberSignupRequest("rnrl1215", "skahn", "tesE@32@#DSAt");

        // when
        Member member = memberService.createMemberAndPassword(mr);

        // then
        Assertions.assertThat(member.getSalt()).isNotNull();
        Assertions.assertThat(member.getPassword()).isNotNull();
    }

    @Test
    void login() {
        // given
        Member member = MemberFixture.member0();
        when(memberRepository.findById(any())).thenReturn(Optional.of(member));

        // when
        MemberLoginResponse memberLoginResponse = memberService.login("test1", "tesE@32@#DSAt");

        // then
        Assertions.assertThat(memberLoginResponse.jwtToken()).isNotNull();
    }
}