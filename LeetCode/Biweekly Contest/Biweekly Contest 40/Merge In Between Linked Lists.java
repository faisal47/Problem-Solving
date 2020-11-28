package practice.problems;

import java.util.Objects;

class ListNode {
	ListNode next;
}

class Solution {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode athNode = getNthNode(list1, a - 1);
		ListNode bthNode = getNthNode(list1, b);
		ListNode lastNodeOfList2 = getLastNode(list2);
		athNode.next = list2;
		lastNodeOfList2.next = bthNode.next;
		return list1;
	}

	private ListNode getLastNode(ListNode node) {
		while (!Objects.isNull(node.next)) {
			node = node.next;
		}
		return node;
	}

	private ListNode getNthNode(ListNode node, int n) {
		while (n > 0) {
			n--;
			node = node.next;
		}
		return node;
	}
}