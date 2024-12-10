package com.leetcode.top.interview.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		
		assertEquals(List.of("0->2","4->5","7"), summaryRanges2(new int[] {0,1,2,4,5,7}));
		assertEquals(List.of("0","2->4","6","8->9"), summaryRanges2(new int[] {0,2,3,4,6,8,9}));

	}
	

	
	// 0 ms solution.
	public static List<String> summaryRanges2(int[] nums) {
		
		int numsLength = nums.length;
		
		if (numsLength == 0) return List.of();
		
		List<String> result = new ArrayList<>();
		
		int start = nums[0];
		for (int i = 1; i <= nums.length; i++) {
			
			if (i == numsLength || nums[i] != nums[i-1] + 1) {
				
				if (start == nums[i-1]) result.add(String.valueOf(start));
				else result.add(String.valueOf(start).concat("->").concat(String.valueOf(nums[i-1])));
				
				if (i < numsLength) start = nums[i];
			}
		}
        return result;
    }
	
	
	public static List<String> summaryRanges1(int[] nums) {
		
		int numsLength = nums.length;
		
		if (numsLength == 0) return List.of();
		
		List<String> result = new ArrayList<>();
		
		int start = nums[0], tmp = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			var currVal = nums[i];
			
			if (tmp + 1 != currVal) {
				if (start == tmp) result.add(start+"");
				else result.add(start + "->" + tmp);
				start = currVal;
				tmp = currVal;
			} else {
				tmp = tmp + 1;
			}
		}
		
		if (tmp == nums[numsLength - 1]) {
			if (start == tmp) result.add(start+"");
			else result.add(start + "->" + tmp);
		};
		
		System.out.println(result);
        return result;
    }

}
