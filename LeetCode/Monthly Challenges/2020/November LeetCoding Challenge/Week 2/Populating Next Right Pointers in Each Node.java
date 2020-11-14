package practice.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

class Solution {
	List<List<Node>> levelWiseNodeList;

	public Node connect(Node root) {
		levelWiseNodeList = new ArrayList<>();
		solve(root, 1);
		solve2();
		return root;
	}

	private void solve2() {
		for (int i = 0; i < levelWiseNodeList.size(); i++)
			for (int j = 1; j < levelWiseNodeList.get(i).size(); j++)
				levelWiseNodeList.get(i).get(j - 1).next = levelWiseNodeList.get(i).get(j);
	}

	private void solve(Node node, int level) {
		if (Objects.isNull(node))
			return;

		if (levelWiseNodeList.size() < level)
			levelWiseNodeList.add(new ArrayList<>());

		levelWiseNodeList.get(level - 1).add(node);
		solve(node.left, level + 1);
		solve(node.right, level + 1);
	}

}