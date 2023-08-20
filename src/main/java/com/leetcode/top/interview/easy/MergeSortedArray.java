package com.leetcode.top.interview.easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        approach1(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        approach1(new int[]{1}, 1, new int[]{}, 0);
        approach1(new int[]{0}, 0, new int[]{1}, 1);

        betterApproach(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        betterApproach(new int[]{1}, 1, new int[]{}, 0);
        betterApproach(new int[]{0}, 0, new int[]{1}, 1);
    }

    private static void approach1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    private static void betterApproach(int[] nums1, int m, int[] nums2, int n) {
        var pointer1Index = m-1;
        var pointer2Index = n-1;

        var currentIndex = m + n - 1; // Last index of nums1, which is equals t0 length of nums1 - 1

        while (pointer2Index >= 0) {
            if (pointer1Index >= 0 && nums1[pointer1Index] > nums2[pointer2Index]) {
                nums1[currentIndex--] = nums1[pointer1Index--];
            } else {
                nums1[currentIndex--] = nums2[pointer2Index--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

}
