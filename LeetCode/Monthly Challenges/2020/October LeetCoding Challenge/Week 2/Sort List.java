
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
	public ListNode sortList(ListNode head) {
		ListNode newHead = null;
		List<Integer> numbers = new ArrayList<>();
		ListNode node = head;
		while (!Objects.isNull(node)) {
			numbers.add(node.val);
			node = node.next;
		}
		Collections.sort(numbers);
		ListNode preNode = null;
		for (int i = 0; i < numbers.size(); i++) {
			int nowNum = numbers.get(i);
			ListNode newNode = new ListNode(nowNum);
			if (Objects.isNull(newHead)) {
				newHead = newNode;
			} else {
				preNode.next = newNode;
			}
			preNode = newNode;
		}
		return newHead;
	}
}