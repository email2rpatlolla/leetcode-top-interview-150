package com.leetcode.top.interview.easy;

import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {
        approach1("Hello World");
        approach1("   fly me   to   the moon  ");
        approach1("luffy is still joyboy");

        betterApproach("Hello World");
        betterApproach("   fly me   to   the moon  ");
        betterApproach("luffy is still joyboy");
    }

    private static int betterApproach(String s) {
        s = s.stripTrailing();
        return s.length() - s.lastIndexOf(" ") - 1;
    }

    private static int approach1(String s) {
        String[] words = s.stripTrailing().split(" ");
        return words[words.length - 1].length();
    }

}
