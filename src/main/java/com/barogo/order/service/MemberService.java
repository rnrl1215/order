package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.dto.MemberRequest;
import com.barogo.order.exception.CustomException;
import com.barogo.order.repository.MemberRepository;
import com.barogo.order.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.barogo.order.exception.ErrorCode.*;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member createMemberAndPassword(MemberRequest memberRequest) throws CustomException {
        checkPassword(memberRequest.password());
        checkDuplicationId(memberRequest.id());

        // TODO : 하나의 함수로 변경
        byte[] salt = PasswordUtils.getSalt();
        String securePassword = PasswordUtils.getSecurePassword(memberRequest.password(), salt);

        return Member.builder()
                .id(memberRequest.id())
                .name(memberRequest.name())
                .password(securePassword)
                .salt(salt)
                .build();
    }

    @Transactional
    public void createMember(MemberRequest memberRequest) {
        Member member = createMemberAndPassword(memberRequest);
        memberRepository.save(member);
    }

    public void checkPassword(String password) {
        boolean isSafePassword = PasswordUtils.checkPassword(password);
        if (!isSafePassword) throw new CustomException(INVALID_PASSWORD);
    }

    public void checkDuplicationId(String id) throws CustomException {
        memberRepository.findById(id).ifPresent(m -> {
            throw new CustomException(EXIST_ID);
        });
    }
}
