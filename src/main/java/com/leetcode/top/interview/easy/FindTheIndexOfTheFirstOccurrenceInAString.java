package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {

        Assertions.assertEquals(0, approach1("sadbutsad", "sad"));
        Assertions.assertEquals(-1, approach1("leetcode", "leeto"));

        Assertions.assertEquals(0, betterApproach("sadbutsad", "sad"));
        Assertions.assertEquals(-1, betterApproach("leetcode", "leeto"));
    }

    private static int betterApproach(String haystack, String needle) {


        return -1;
    }

    private static int approach1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

}
