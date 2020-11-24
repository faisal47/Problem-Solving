package practice.problems;

import java.util.Objects;

class Solution {
	public int rob(TreeNode root) {
		return solve(root, true);
	}

	private int solve(TreeNode node, boolean canTake) {
		if (Objects.isNull(node))
			return 0;
		int ans = 0;
		if (canTake) {
			ans = node.val + solve(node.left, false) + solve(node.right, false);
		}
		ans = Math.max(ans, solve(node.left, true) + solve(node.right, true));
		return ans;
	}
}

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