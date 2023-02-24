package com.barogo.order.controller;


import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.MemberLoginResponse;
import com.barogo.order.dto.MemberSignupRequest;
import com.barogo.order.dto.MemberLoginRequest;
import com.barogo.order.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity signupMember(@Validated @RequestBody MemberSignupRequest memberSignupRequest) {
        memberService.createMember(memberSignupRequest);
        return CustomResponseEntity.createCustomResponseEntity("Requested signup service", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Validated @RequestBody MemberLoginRequest memberloginRequest) {
        MemberLoginResponse loginResponse = memberService.login(memberloginRequest.id(), memberloginRequest.password());
        return CustomResponseEntity.createCustomResponseEntity(loginResponse, "Requested login service", HttpStatus.OK);
    }
}
