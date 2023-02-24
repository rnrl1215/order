package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.dto.MemberLoginResponse;
import com.barogo.order.dto.MemberSignupRequest;
import com.barogo.order.exception.CustomErrorCodeException;
import com.barogo.order.repository.MemberRepository;
import com.barogo.order.utils.JWTUtils;
import com.barogo.order.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.barogo.order.exception.ErrorCode.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberLoginResponse login(String id, String password) {
        Member foundMember = findById(id);

        byte[] salt = foundMember.getSalt();
        String securePassword = PasswordUtils.getSecurePassword(password, salt);

        if (!securePassword.equals(foundMember.getPassword())) {
            throw new CustomErrorCodeException(BAD_CREDENTIALS);
        }

        String jwtToken = JWTUtils.generateJWTToken(foundMember);

        return new MemberLoginResponse(id, jwtToken);
    }

    private Member findById(String id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new CustomErrorCodeException(NOT_EXIST_ID)
        );
    }

    @Transactional
    public void createMember(MemberSignupRequest memberSignupRequest) {
        Member member = createMemberAndPassword(memberSignupRequest);
        memberRepository.save(member);
    }

    public Member createMemberAndPassword(MemberSignupRequest memberSignupRequest) throws CustomErrorCodeException {
        checkPassword(memberSignupRequest.password());
        checkDuplicationId(memberSignupRequest.id());

        // TODO : 하나의 함수로 변경
        byte[] salt = PasswordUtils.getSalt();
        String securePassword = PasswordUtils.getSecurePassword(memberSignupRequest.password(), salt);

        return Member.builder()
                .id(memberSignupRequest.id())
                .name(memberSignupRequest.name())
                .password(securePassword)
                .salt(salt)
                .build();
    }

    public void checkPassword(String password) {
        boolean isSafePassword = PasswordUtils.checkPasswordPattern(password);
        if (!isSafePassword) throw new CustomErrorCodeException(INVALID_PASSWORD);
    }

    public void checkDuplicationId(String id) throws CustomErrorCodeException {
        memberRepository.findById(id).ifPresent(m -> {
            throw new CustomErrorCodeException(EXIST_ID);
        });
    }

}
