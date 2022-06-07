package com.leetcode;

public class HL167 {
    public static void main(String[] args) {
        HL167 hl167 = new HL167();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = hl167.twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < numbers.length; ) {
            int num = numbers[i] + numbers[j];
            if (num > target)
                j--;
            else if (num < target)
                i++;
            else return new int[]{i + 1, j + 1};
        }
        return new int[0];
    }
}
