package com.barogo.order.controller;


import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.MemberRequest;
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
    public ResponseEntity signupMember(@Validated @RequestBody MemberRequest memberRequest) {
        memberService.createMember(memberRequest);
        return CustomResponseEntity.<MemberRequest>createCustomResponseEntity(null, "Requested signup service", HttpStatus.CREATED);
    }
}
