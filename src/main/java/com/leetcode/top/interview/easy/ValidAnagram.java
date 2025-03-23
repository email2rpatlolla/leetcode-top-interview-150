package com.leetcode.top.interview.easy;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses
 * 
 * */
public class ValidAnagram {

    public static void main(String[] args) {

        Assertions.assertEquals(true, isAnagram("anagram", "nagaram"));
		Assertions.assertEquals(false, isAnagram("rat", "car"));
    }

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) return false;

		var alphabetArray = new int[26];

		for (int i = 0; i< s.length(); i++) {
			++alphabetArray[s.charAt(i) - 'a'];
			--alphabetArray[t.charAt(i) - 'a'];
		}

		for (int alphabetCount: alphabetArray) {
			if (alphabetCount != 0) return false;
		}

		return true;
	}

	public static boolean isAnagramMap(String s, String t) {

		if (s.length() != t.length()) return false;

		var map = new HashMap<Character, Integer>(s.length());
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		for (int i = 0; i < t.length(); i++) {

			char c = t.charAt(i);
			if (map.containsKey(c)) {
				var count = map.get(c) - 1;
				if (count <= 0) map.remove(c);
				else map.put(c, count);
			} else return false;
		}
		return true;
	}

	public static boolean isAnagramSort(String s, String t) {

		if (s.length() != t.length()) return false;

		var ss = s.toCharArray();
		Arrays.sort(ss);

		var ts = t.toCharArray();
		Arrays.sort(ts);

		return Arrays.equals(ss, ts);

	}

}
