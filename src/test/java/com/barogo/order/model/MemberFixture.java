package com.barogo.order.model;

import com.barogo.order.domain.Member;

public class MemberFixture {
    public static Member member0() {

        byte[] salt = {22, 125, 17, 127, 80, 109, -108, -37, 108, 96, -6, -100, 38, -62, 0, -11};

        return Member.builder()
                .password("c600eadd1ee4b314338e68f5603f525bea254c9899de6136f60b4f48c11533ff")
                .id("test1")
                .salt(salt)
                .build();
    }
}
