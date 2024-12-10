

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.jupiter.api.Assertions;

/*
 * https://leetcode.com/problems/contains-duplicate-ii
 * 
 * */
public class ContainsDuplicateII {

    public static void main(String[] args) {

        Assertions.assertEquals(true, approach1(new int[] {1,2,3,1}, 3));
        Assertions.assertEquals(true, approach1(new int[] {1,0,1,1}, 1));
        Assertions.assertEquals(false, approach1(new int[] {1,2,3,1,2,3}, 2));
    }

    private static boolean approach1(int[] nums, int k) {
    	
    	Map<Integer, Integer> map = new HashMap<>(nums.length);
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		if (map.containsKey(nums[i])) {
    			var prevIndex = map.get(nums[i]);
    			if (i - prevIndex <= k) return true;
    		}
    		map.put(nums[i], i);
		}
    	return false;
    }
}
