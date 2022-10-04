package com.leetcode;

import java.util.*;

public class HL8plus {
    public static void main(String[] args) {
        int i = new HL8plus().myAtoi("-342142354151235");
        System.out.println(i);
    }
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length() && !automaton.status.equals("end"); i++) {
            automaton.get(s.charAt(i));
        }
        return (int)automaton.num * automaton.sign;
    }
}
class Automaton {
    int sign = 1;
    long num = 0;
    String status = "start";
    static final long INT_MAX_WITHOUT_SIGN = -(long)Integer.MIN_VALUE;
    Map<String, List<String>> table = new HashMap<>(4){{
        put("start", Arrays.asList("start", "sign", "num", "end"));
        put("sign", Arrays.asList("end", "end", "num", "end"));
        put("num", Arrays.asList("end", "end", "num", "end"));
        put("end", Arrays.asList("end", "end", "end", "end"));
    }};

    public void get(char tmp) {
        status = table.get(status).get(getColumn(tmp));
        if (status.equals("num")) {
            num = num * 10 + tmp - '0';
            num = sign == 1 ? Math.min(Integer.MAX_VALUE, num) : Math.min(INT_MAX_WITHOUT_SIGN, num);
        } else if (status.equals("sign")) {
            if (tmp == '-') sign = -1;
            else if (tmp == '+') sign = 1;
        }
    }
    public int getColumn(char tmp) {
        if (tmp == ' ') return 0;
        if (tmp == '+' || tmp == '-') return 1;
        if (tmp >= '0' && tmp <= '9') return 2;
        return 3;
    }
}