package practice.problems;

import java.util.Objects;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	int tiltSummation;

	public int findTilt(TreeNode root) {
		tiltSummation = 0;
		solve(root);
		return tiltSummation;
	}

	private int solve(TreeNode node) {
		if (Objects.isNull(node))
			return 0;
		int treeSum = node.val;
		int leftTreeSum = solve(node.left);
		int rightTreeSum = solve(node.right);
		tiltSummation += Math.abs(leftTreeSum - rightTreeSum);
		treeSum += (leftTreeSum + rightTreeSum);
		return treeSum;
	}
}