package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.exception.CustomException;

public class MemberService {



    public void passwordCheck(String password) throws CustomException {

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isSpecialCharacters = false;
        boolean isNumber = false;

        for(int i = 0; i < password.length(); i++){
            char charPassword = password.charAt(i);
            if (!isUpperCase && Character.isUpperCase(password.charAt(charPassword))) {
                isUpperCase = true;
            } else if (!isLowerCase && Character.isLowerCase(charPassword)) {
                isLowerCase = true;
            } else if (!isNumber) {

            }
        }
    }
}
