package com.java.practice.solved;

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
	List<TreeNode> levelNodeList;

	public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
		int level = getLevel(root, u, 0);
		levelNodeList = new ArrayList<>();
		createLevelNodeList(root, 0, level);
		for (int i = 0; i < levelNodeList.size() - 1; i++)
			if (levelNodeList.get(i).val == u.val)
				return levelNodeList.get(i + 1);
		return null;
	}

	private void createLevelNodeList(TreeNode node, int nowLevel, int level) {

		if (Objects.isNull(node))
			return;
		if (nowLevel == level) {
			levelNodeList.add(node);
			return;
		}
		createLevelNodeList(node.left, nowLevel + 1, level);
		createLevelNodeList(node.right, nowLevel + 1, level);
	}

	private int getLevel(TreeNode node, TreeNode u, int level) {

		if (Objects.isNull(node))
			return 0;

		if (node.val == u.val)
			return level;

		return Math.max(getLevel(node.left, u, level + 1), getLevel(node.right, u, level + 1));
	}
}