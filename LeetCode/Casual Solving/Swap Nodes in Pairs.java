package com.java.practice;

import java.util.Objects;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode swapPairs(ListNode head) {

		if (Objects.isNull(head) || Objects.isNull(head.next))
			return head;

		ListNode preNode = null;
		ListNode nowNode = head;

		while (!Objects.isNull(nowNode) && !Objects.isNull(nowNode.next)) {
			ListNode nextNow = nowNode.next.next;
			ListNode next = nowNode.next;

			if (Objects.isNull(preNode)) {
				head = next;
			} else {
				preNode.next = next;
			}
			next.next = nowNode;
			nowNode.next = nextNow;
			preNode = nowNode;
			nowNode = nextNow;
		}
		return head;
	}
}