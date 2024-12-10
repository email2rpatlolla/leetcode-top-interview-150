package com.leetcode.top.interview.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;

import com.leetcode.linkedlist.LinkedListUtil;
import com.leetcode.linkedlist.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		
		assertEquals(true, hasCycle(LinkedListUtil.createListNodeCycle(List.of(3, 2, 0, -4), 1)));
		assertEquals(true, hasCycle(LinkedListUtil.createListNodeCycle(List.of(1, 2), 0)));
		assertEquals(false, hasCycle(LinkedListUtil.createListNodeCycle(List.of(1), -1)));
		assertEquals(false, hasCycle(LinkedListUtil.createListNodeCycle(List.of(), -1)));
	}
	

	public static boolean hasCycle(ListNode head) {
		
		if (Objects.isNull(head)) return false; 
		
		ListNode slow = head;
		ListNode fast = head.next != null ? head.next.next  : null;
		
		while (fast != null && fast != slow) {
			slow = slow.next;
			fast = fast.next != null ? fast.next.next  : null;
		}
		
		return fast != null;
	}
	
	public static ListNode nextListNode(int n) {

		return null;
	}
	

}
