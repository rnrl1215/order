package com.barogo.order.controller;


import com.barogo.order.common.CustomResponseEntity;
import com.barogo.order.dto.MemberRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class MemberController {

    @PostMapping("/signup")
    public ResponseEntity signupMember(@Validated @RequestBody MemberRequest memberRequest) {
        return CustomResponseEntity.<MemberRequest>createCustomResponseEntity(memberRequest, "Requested signup service", HttpStatus.CREATED);
    }
}
