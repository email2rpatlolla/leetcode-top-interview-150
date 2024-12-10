package com.leetcode.top.interview.easy;

import java.util.List;
import java.util.Objects;

import com.leetcode.linkedlist.LinkedListUtil;
import com.leetcode.linkedlist.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		removeElements(LinkedListUtil.createListNode(List.of(1, 2, 6, 3, 4, 5, 6)), 6);
		removeElements(LinkedListUtil.createListNode(List.of()), 1);
	}

	public static ListNode removeElements(ListNode head, int val) {
		LinkedListUtil.printListNode(head);
		
		
		ListNode resNode = new ListNode(-1, head);
		ListNode prevNode = resNode;
		
		while (Objects.nonNull(head)) {
			if (head.val == val) {
				prevNode.next = head.next;
			} else {
				prevNode = head;
			}
			head = head.next;
		} 
		LinkedListUtil.printListNode(resNode.next);
		return resNode.next;
	}

}
