package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        Assertions.assertEquals("fl", betterApproach(new String[]{"flower","flow","flight"}));
        Assertions.assertEquals("", betterApproach(new String[]{"dog","racecar","car"}));
    }

    private static String betterApproach(String[] strs) {
        Arrays.sort(strs);
        var counter = 0;
        var first = strs[0];
        var last = strs[strs.length-1];

        while(counter < first.length()) {
            if (first.charAt(counter) == last.charAt(counter)) {
                counter++;
            } else break;
        }
        return first.substring(0, counter);
    }
}
