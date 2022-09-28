package com.leetcode;

public class HL6 {
    public static void main(String[] args) {
        HL6 hl6 = new HL6();
        String s = "abcdef";
        int num = 5;
        String convert = hl6.convert(s, num);
        System.out.printf(convert);
    }
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int gap = 2 * numRows - 2;
        for (int j = 0; j < s.length(); j += gap) {
            sb.append(s.charAt(j));
        }
        for (int i = 1; i < numRows - 1; i++) {
            int less = 2 * i;
            int more = gap - less;
            for (int j = i; j < s.length();) {
                sb.append(s.charAt(j));
                j += more;
                if (j > s.length() - 1) break;
                sb.append(s.charAt(j));
                j += less;
            }
        }

        for (int j = numRows - 1; j < s.length(); j += gap) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
