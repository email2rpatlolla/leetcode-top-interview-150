package com.leetcode.top.interview.easy;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        approach1(new int[]{3,2,2,3}, 3);
        approach1(new int[]{0,1,2,2,3,0,4,2}, 2);

        betterApproach(new int[]{3,2,2,3}, 3);
        betterApproach(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    private static int approach1(int[] nums, int val) {
        int returnValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) returnValue++;
            else nums[i] = Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        return returnValue;
    }

    private static int betterApproach(int[] nums, int val) {
        int returnValue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[returnValue++] = nums[i];
            }
        }
        return returnValue;
    }

}
