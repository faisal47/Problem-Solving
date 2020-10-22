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
	public int minDepth(TreeNode root) {
		if (Objects.isNull(root))
			return 0;
		return getMinDep(root);
	}

	private int getMinDep(TreeNode node) {
		if (Objects.isNull(node.left) && Objects.isNull(node.right))
			return 1;
		int ret = 100005;
		if (!Objects.isNull(node.left))
			ret = Math.min(ret, 1 + getMinDep(node.left));
		if (!Objects.isNull(node.right))
			ret = Math.min(ret, 1 + getMinDep(node.right));
		return ret;
	}
}