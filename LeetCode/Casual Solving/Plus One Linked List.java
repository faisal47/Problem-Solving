package com.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	public ListNode plusOne(ListNode head) {
		List<Integer> digits = getDigitsList(head);
		Collections.reverse(digits);
		addOneToDigits(digits);
		Collections.reverse(digits);
		return getNewListNodes(digits);
	}

	private ListNode getNewListNodes(List<Integer> digits) {
		ListNode head = null;
		ListNode preNode = null;
		for (int i = 0; i < digits.size(); i++) {
			if (Objects.isNull(preNode)) {
				head = new ListNode(digits.get(i));
				preNode = head;
			} else {
				ListNode nowNode = new ListNode(digits.get(i));
				preNode.next = nowNode;
				preNode = nowNode;
			}
		}
		return head;
	}

	private void addOneToDigits(List<Integer> digits) {
		int addValue = 1;
		for (int i = 0; i < digits.size(); i++) {
			addValue += digits.get(i);
			digits.set(i, addValue % 10);
			addValue /= 10;
		}
		if (addValue > 0)
			digits.add(addValue);
	}

	private List<Integer> getDigitsList(ListNode node) {
		List<Integer> digits = new ArrayList<>();
		while (!Objects.isNull(node)) {
			digits.add(node.val);
			node = node.next;
		}
		return digits;
	}
}