package com.leetcode.top.interview.easy;

import java.util.List;
import java.util.Objects;

import com.leetcode.linkedlist.LinkedListUtil;
import com.leetcode.linkedlist.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		reverseList(LinkedListUtil.createListNode(List.of(1, 2, 3, 4, 5)));
		reverseList(LinkedListUtil.createListNode(List.of(1, 2)));
		reverseList(LinkedListUtil.createListNode(List.of()));
	}

	public static ListNode reverseList(ListNode head) {

		LinkedListUtil.printListNode(head);
		ListNode currentNode = head;
		ListNode prevNode = null;
		
		while (Objects.nonNull(currentNode)) {
			var tempNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = tempNode;
		}
		LinkedListUtil.printListNode(prevNode);
		return prevNode;
	}

}
