package com.leetcode.top.interview.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    public static void main(String[] args) {
        approach1(new int[]{3,2,3});
        approach1(new int[]{2,2,1,1,1,2,2});

        approach2(new int[]{3,2,3});
        approach2(new int[]{2,2,1,1,1,2,2});


        betterApproach(new int[]{3,2,3});
        betterApproach(new int[]{2,2,1,1,1,2,2});
    }

    private static int betterApproach(int[] nums) {
        /*
            Moore Voting Algorithm
            - If there is a majority element in an array, it will always remain in the lead,
            even after encountering other elements

         */
        var count = 1;
        var element = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) element = nums[i];
            if (element == nums[i]) count++;
            else count--;

        }
        return element;
    }

    private static int approach2(int[] nums) {
        /*
            A number which occurs n/2 times.
            That means, when the array is sorted,
            we always get that number in the middle of the array as it repated equals or more than n/2 times
         */
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    private static int approach1(int[] nums) {
        var x = Arrays.stream(nums)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return x.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

}
