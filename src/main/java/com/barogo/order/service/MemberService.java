package com.barogo.order.service;

import com.barogo.order.domain.Member;
import com.barogo.order.exception.CustomException;

public class MemberService {



    public void checkPassword(String password) throws CustomException {

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isSpecialCharacters = false;
        boolean isNumber = false;

        boolean matches = password.matches("[0-9]");
        boolean matches1 = password.matches("[a-z]");
        boolean matches2 = password.matches("[A-Z]");
        boolean matches3 = password.matches("[\\{\\}\\[\\]\\/?.,;:|\\)*~`!^\\-_+<>@\\#$%&\\\\\\=\\(\\'\\\"]");


    }
}
