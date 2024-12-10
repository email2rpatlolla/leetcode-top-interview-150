package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

public class IsSubsequence {

    public static void main(String[] args) {

        Assertions.assertEquals(true, approach1("abc", "ahbgdc"));
        Assertions.assertEquals(false, approach1("axc", "ahbgdc"));
        Assertions.assertEquals(false, approach1("acb", "ahbgdc"));
        Assertions.assertEquals(false, approach1("aaaaa", "bcaaa"));

        Assertions.assertEquals(true, approach2("abc", "ahbgdc"));
        Assertions.assertEquals(false, approach2("axc", "ahbgdc"));
        Assertions.assertEquals(false, approach2("acb", "ahbgdc"));
        Assertions.assertEquals(false, approach2("aaaaa", "bcaaa"));

        Assertions.assertEquals(true, betterApproach("abc", "ahbgdc"));
        Assertions.assertEquals(false, betterApproach("axc", "ahbgdc"));
        Assertions.assertEquals(false, betterApproach("acb", "ahbgdc"));
        Assertions.assertEquals(false, betterApproach("aaaaa", "bcaaa"));

    }

    private static boolean betterApproach(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();

        while (sIndex < s.length() && tIndex < t.length()) {
            if (tCharArray[tIndex++] == sCharArray[sIndex]) {
                sIndex++;
            }
        }
        return sIndex == s.length();
    }

    private static boolean approach1(String s, String t) {
        var prevIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            prevIndex = t.indexOf(s.charAt(i), prevIndex);
            if (prevIndex++ < 0)  return false;
        }
        return true;
    }

    private static boolean approach2(String s, String t) {
        var sIndex = 0;
        for (int i = 0; i < t.length() && sIndex < s.length(); i++) {
            if (s.charAt(sIndex) == t.charAt(i)) sIndex++;
        }
        return sIndex == s.length();
    }
}
