package practice.problems;

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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> l1List = getList(l1);
		List<Integer> l2List = getList(l2);
		List<Integer> ansList = getSumList(l1List, l2List);
		return getLinkedList(ansList);
	}

	private ListNode getLinkedList(List<Integer> ansList) {
		ListNode head = null;
		ListNode pre = null;
		for (int i = 0; i < ansList.size(); i++) {
			ListNode listNode = new ListNode(ansList.get(i));
			if (Objects.isNull(head))
				head = pre = listNode;
			else {
				pre.next = listNode;
				pre = listNode;
			}
		}
		return head;
	}

	private List<Integer> getSumList(List<Integer> l1List, List<Integer> l2List) {
		List<Integer> ansList = new ArrayList<>();
		int c1 = 0;
		int c2 = 0;
		int nowNumber = 0;
		while (c1 < l1List.size() || c2 < l2List.size() || nowNumber > 0) {
			if (c1 < l1List.size())
				nowNumber += l1List.get(c1++);

			if (c2 < l2List.size())
				nowNumber += l2List.get(c2++);

			ansList.add(nowNumber % 10);
			nowNumber /= 10;
		}
		Collections.reverse(ansList);
		return ansList;
	}

	private List<Integer> getList(ListNode l) {
		List<Integer> retList = new ArrayList<>();
		while (!Objects.isNull(l)) {
			retList.add(l.val);
			l = l.next;
		}
		Collections.reverse(retList);
		return retList;
	}
}