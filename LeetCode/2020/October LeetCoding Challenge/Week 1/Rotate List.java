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
	public ListNode rotateRight(ListNode head, int k) {
		if (Objects.isNull(head))
			return head;
		int listSize = getTreeSize(head);
		k %= listSize;
		if (k == 0)
			return head;
		return getNewHeadAfterRotation(head, k, listSize);
	}

	private ListNode getNewHeadAfterRotation(ListNode head, int k, int listSize) {
		int targetHeadCount = listSize - k;
		ListNode preNode = head;
		ListNode nowNode = head.next;
		int nowHeadCount = 1;
		makeCycle(head);
		while (true) {
			if (nowHeadCount == targetHeadCount) {
				preNode.next = null;
				return nowNode;
			}
			preNode = nowNode;
			nowNode = nowNode.next;
			nowHeadCount++;
		}
	}

	private void makeCycle(ListNode head) {
		ListNode lastNode = getLastNode(head);
		lastNode.next = head;
	}

	private ListNode getLastNode(ListNode node) {
		while (!Objects.isNull(node.next)) {
			node = node.next;
		}
		return node;
	}

	private int getTreeSize(ListNode node) {
		int treeSize = 0;
		while (!Objects.isNull(node)) {
			treeSize++;
			node = node.next;
		}
		return treeSize;
	}
}