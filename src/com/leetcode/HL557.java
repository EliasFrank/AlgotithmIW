package com.leetcode;

public class HL557 {
    public static void main(String[] args) {
        System.out.println(new HL557().reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ')
                i++;
            int end = i;
            while (--i >= start) {
                sb.append(s.charAt(i));
            }
            sb.append(' ');
            i = end + 1;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
    /*public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = 0; i < s.length();) {
            char tmpChar = ' ';
            while(i < s.length() && (tmpChar = s.charAt(i++)) != ' ') {
                sb.insert(len, tmpChar);
            }
            sb.append(' ');
            len = sb.length();
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }*/
