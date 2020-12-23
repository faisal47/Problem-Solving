package com.java.practice.solved;

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
	boolean resultFlag;

	public boolean isBalanced(TreeNode root) {
		resultFlag = true;
		dfs(root);
		return resultFlag;
	}

	private int dfs(TreeNode node) {
		if (Objects.isNull(node))
			return -1;

		int leftLevel = 1 + dfs(node.left);
		int rightLevel = 1 + dfs(node.right);

		if (Math.abs(rightLevel - leftLevel) > 1)
			resultFlag = false;

		return Math.max(leftLevel, rightLevel);
	}
}