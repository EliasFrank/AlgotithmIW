package com.leetcode;

public class HL8 {
    public static void main(String[] args) {
        int i = new HL8().myAtoi("1432142142342143242341523");
        System.out.println(i);
    }
    public int myAtoi(String s) {
        long result = 0;
        int flag = 1;
        char[] chars = s.toCharArray();
        int i  =0;
        for (;i < chars.length && chars[i] == ' ';i++);
        if (i >= chars.length) return 0;
        if (chars[i] == '-')
            flag = -1;
        else if (chars[i] == '+')
            flag = 1;
        else {
            i--;
        }
        i++;
        int j = 0;
        while (i < chars.length && chars[i] == '0') i++;
        while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {
            result = result * 10 + (chars[i] - '0');
            i++;
            j++;
            if (j > 12) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        result *= flag;
        if (result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;
        else if (result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        return (int)result;
    }
}