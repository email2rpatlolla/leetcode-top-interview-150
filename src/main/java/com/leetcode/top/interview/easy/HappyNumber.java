package com.leetcode.top.interview.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		
		assertEquals(true, floydAlgo(19));
		assertEquals(false, floydAlgo(2));
		assertEquals(true, floydAlgo(7));
		assertEquals(false, floydAlgo(4));
		assertEquals(true, floydAlgo(10));
		assertEquals(false, floydAlgo(14));
		
	}
	

	public static boolean floydAlgo(int n) {
		
		int slow = nextNumber(n);
		int fast = nextNumber(slow);
		
		/**
		 * slow will be equals to fast when
		 * 	- Both the values are equals to 1
		 *  - When the loop entry point in multiple iterations, 145 in the below example
		 *  	 (5 -> 25 -> 29 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145)
		 * 
		 * */
		while (slow != fast) {
			slow = nextNumber(slow);
			fast = nextNumber(nextNumber(fast));
		}
		return fast == 1;
	}
	
	public static int nextNumber(int n) {
		int sum = 0;
		
		while (n > 0) {
			int lastDigit = n%10;
			sum += lastDigit * lastDigit;
			n = n/10;
		}
		return sum;
	}
	
	public static boolean isHappy2(int n) {
		
		int sum = 0;
		Set<Integer> history = new HashSet<>();

		while (!history.contains(n)) {
			history.add(n);
			sum = 0;
			while (n > 0) {
				int lastDigit = n%10;

				sum += lastDigit * lastDigit;
				
				n = n/10;

			}
			n = sum;
		}
		
		return n == 1;
	}
	
	public static boolean isHappy1(int n) {
		
		int sum = 0;
		
		while (n > 9) {
			sum = 0;
			while (n > 0) {
				int lastDigit = n%10;

				sum += lastDigit * lastDigit;
				
				n = n/10;

			}
			n = sum;
		}
		
		return n == 1 || n == 7;
	}

}
