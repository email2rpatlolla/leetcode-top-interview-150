package com.leetcode.top.interview.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic1("egg", "add"));
        System.out.println(isIsomorphic1("foo", "bar"));
        System.out.println(isIsomorphic1("paper", "title"));
        System.out.println(isIsomorphic1("badc", "baba"));
    }

    public static boolean isIsomorphic1(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i =0; i< s.length(); i++) {
            var char1 = s.charAt(i);
            var char2 = t.charAt(i);

            var val = map.get(char1);
            if (val != null) {
                if (val != char2) return false;
            } else if (map.containsValue(char2)) return false;
            else {
                map.put(char1, char2);
            }
        }
        return true;
    }
}
