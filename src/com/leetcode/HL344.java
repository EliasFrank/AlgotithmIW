package com.leetcode;

public class HL344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new HL344().reverseString(s);
        for (char c : s) {
            System.out.print(c + " ");
        }
    }
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
    }
    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
