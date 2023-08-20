package com.leetcode.top.interview.easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        approach1(new int[]{1,1,2});
        approach1(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    private static int approach1(int[] nums) {
        int currIndex = 0;
        int currValue = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (currValue != nums[i]) {
                currValue = nums[i];
                nums[++currIndex] = currValue;
            }
        }
        return currIndex + 1;
    }

}
