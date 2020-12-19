package practice.problems;

import java.util.ArrayList;
import java.util.List;
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
	List<List<Integer>> ansList;

	public List<List<Integer>> levelOrder(TreeNode root) {
		ansList = new ArrayList<>();
		dfs(root, 1);
		return ansList;
	}

	private void dfs(TreeNode node, int dep) {
		if (Objects.isNull(node))
			return;
		if (ansList.size() < dep)
			ansList.add(new ArrayList<>());
		ansList.get(dep - 1).add(node.val);
		dfs(node.left, dep + 1);
		dfs(node.right, dep + 1);
	}
}