package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    public static void main(String[] args) {

        Assertions.assertEquals(false, approach1("a", "b"));
        Assertions.assertEquals(false, approach1("aa", "ab"));
        Assertions.assertEquals(true, approach1("aa", "aab"));


        Assertions.assertEquals(false, betterApproach("a", "b"));
        Assertions.assertEquals(false, betterApproach("aa", "ab"));
        Assertions.assertEquals(true, betterApproach("aa", "aab"));

    }

    private static boolean betterApproach(String ransomNote, String magazine) {

        if (magazine.length() < ransomNote.length()) return false;

        int[] charCounts = new int[26];
        for (int i = 0; i < magazine.length(); i++) charCounts[magazine.charAt(i) - 'a']++;

        for (Character c: ransomNote.toCharArray()) {
            if (charCounts[c - 'a']-- <= 0) return false;
        }

        return true;
    }

    private static boolean approach1(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        var countByChar = magazine.chars()
                .mapToObj(e->(char)e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Character c: ransomNote.toCharArray()) {
            var count = countByChar.getOrDefault(c, 0L);
            if (count <= 0) return false;
            countByChar.put(c, --count);
        }
        return true;
    }


}
