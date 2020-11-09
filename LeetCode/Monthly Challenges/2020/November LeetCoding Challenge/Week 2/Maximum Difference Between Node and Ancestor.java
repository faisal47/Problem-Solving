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

	TreeNode(int val, TreeNode left, TreeNode right) {ecli
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class MiniMaxiValue {
	int miniValue;
	int maxiValue;

	public MiniMaxiValue(int val) {
		this.miniValue = val;
		this.maxiValue = val;
	}

	public MiniMaxiValue(int miniValue, int maxiValue) {
		this.miniValue = miniValue;
		this.maxiValue = maxiValue;
	}
}

class Solution {
	int ans = 0;

	public int maxAncestorDiff(TreeNode root) {
		solve(root);
		return ans;
	}

	private MiniMaxiValue solve(TreeNode node) {
		if (Objects.isNull(node))
			return new MiniMaxiValue(100000, -100000);
		MiniMaxiValue miniMaxiValue = new MiniMaxiValue(node.val);
		MiniMaxiValue leftMiniMaxValue = solve(node.left);
		MiniMaxiValue rightMiniMaxValue = solve(node.right);
		miniMaxiValue.miniValue = Math.min(miniMaxiValue.miniValue,
				Math.min(leftMiniMaxValue.miniValue, rightMiniMaxValue.miniValue));

		miniMaxiValue.maxiValue = Math.max(miniMaxiValue.maxiValue,
				Math.max(leftMiniMaxValue.maxiValue, rightMiniMaxValue.maxiValue));
		ans = Math.max(ans,
				Math.max(Math.abs(node.val - miniMaxiValue.miniValue), Math.abs(node.val - miniMaxiValue.maxiValue)));
		return miniMaxiValue;
	}
}