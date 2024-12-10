package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

public class ValidPalindrome {

    public static void main(String[] args) {

        Assertions.assertEquals(true, approach1("A man, a plan, a canal: Panama"));
        Assertions.assertEquals(false, approach1("race a car"));
        Assertions.assertEquals(true, approach1(" "));

        Assertions.assertEquals(true, betterApproach("A man, a plan, a canal: Panama"));
        Assertions.assertEquals(false, betterApproach("race a car"));
        Assertions.assertEquals(true, betterApproach(" "));
        Assertions.assertEquals(true, betterApproach("0P"));


    }

    private static boolean betterApproach(String s) {
        s = s.toLowerCase();

        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex <= endIndex) {
            char startChar = s.charAt(startIndex);
            if (!(startChar >= 'a' && startChar <= 'z' || startChar >= '0' && startChar <= '9')) {
                startIndex++;
                continue;
            }
            char endChar = s.charAt(endIndex);
            if (!(endChar >= 'a' && endChar <= 'z' || endChar >= '0' && endChar <= '9')) {
                endIndex--;
                continue;
            }
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) return false;
        }
        return true;
    }

    private static boolean approach1(String s) {

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if (s.length() <= 1) return true;

        int startIndex = 0;
        int endIndex = s.length() - 1;

        while (startIndex < endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) return false;
        }
        return true;
    }
}
