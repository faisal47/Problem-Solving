package com.java.practice;

import java.util.Objects;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Solution {
	TreeNode ansNode;

	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		ansNode = null;
		dfs(cloned, target);
		return ansNode;
	}

	private void dfs(TreeNode node, TreeNode target) {
		if (Objects.isNull(node) || !Objects.isNull(ansNode))
			return;
		if (node.val == target.val)
			ansNode = node;
		dfs(node.left, target);
		dfs(node.right, target);
	}
}