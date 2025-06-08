package com.validated.app.application.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CpfValidatedUtils {

    public boolean isValidCpf(String cpf) {
        if (cpf.matches("(\\d)\\1{10}")) return false;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 9; i++) {
            int digit = cpf.charAt(i) - '0';
            sum1 += digit * (10 - i);
            sum2 += digit * (11 - i);
        }
        int check1 = 11 - (sum1 % 11);
        check1 = (check1 >= 10) ? 0 : check1;
        sum2 += check1 * 2;
        int check2 = 11 - (sum2 % 11);
        check2 = (check2 >= 10) ? 0 : check2;
        return check1 == (cpf.charAt(9) - '0') && check2 == (cpf.charAt(10) - '0');
    }

    public boolean isValidCnpj(String cnpj) {
        if (cnpj.matches("(\\d)\\1{13}")) return false;
        int[] weight1 = {5,4,3,2,9,8,7,6,5,4,3,2};
        int[] weight2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 12; i++) {
            int digit = cnpj.charAt(i) - '0';
            sum1 += digit * weight1[i];
            sum2 += digit * weight2[i];
        }
        int check1 = sum1 % 11;
        check1 = (check1 < 2) ? 0 : 11 - check1;
        sum2 += check1 * weight2[12];
        int check2 = sum2 % 11;
        check2 = (check2 < 2) ? 0 : 11 - check2;
        return check1 == (cnpj.charAt(12) - '0') && check2 == (cnpj.charAt(13) - '0');
    }
}
