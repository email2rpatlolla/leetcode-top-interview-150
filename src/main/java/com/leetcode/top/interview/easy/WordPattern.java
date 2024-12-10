package com.leetcode.top.interview.easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;

/*
 * https://leetcode.com/problems/word-pattern
 * 
 * */
public class WordPattern {

	public static void main(String[] args) {

		Assertions.assertEquals(true, approach1("abba", "dog cat cat dog"));
		Assertions.assertEquals(false, approach1("abba", "dog cat cat fish"));
		Assertions.assertEquals(false, approach1("aaaa", "dog cat cat dog"));
		Assertions.assertEquals(false, approach1("abba", "dog dog dog dog"));
	}

	private static boolean approach1(String pattern, String s) {
		var patternArray = pattern.toCharArray();
		var sArray = s.split(" ");

		if (patternArray.length != sArray.length)
			return false;

		Map<Character, String> items = new HashMap<>(patternArray.length);

		for (int i = 0; i < patternArray.length; i++) {
			var keyExists = items.containsKey(patternArray[i]);

			if ((keyExists && !items.get(patternArray[i]).equals(sArray[i]))
					|| (!keyExists && items.containsValue(sArray[i]))) {
				return false;
			} else
				items.put(patternArray[i], sArray[i]);
		}

		return true;
	}
}
