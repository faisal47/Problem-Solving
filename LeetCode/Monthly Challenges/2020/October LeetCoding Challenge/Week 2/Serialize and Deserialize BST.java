
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

class Codec {

	public String serialize(TreeNode root) {
		if (Objects.isNull(root))
			return "";
		List<Integer> treeNodeList = getTreeNodeList(root);
		return getNodeListToString(treeNodeList);
	}

	private String getNodeListToString(List<Integer> treeNodeList) {
		StringBuilder treeData = new StringBuilder();
		for (int i = 0; i < treeNodeList.size(); i++) {
			if (i > 0)
				treeData.append(',');
			int nowNodeVal = treeNodeList.get(i);
			if (nowNodeVal != -1)
				treeData.append(nowNodeVal);
		}
		return treeData.toString();
	}

	private List<Integer> getTreeNodeList(TreeNode node) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		List<Integer> treeNodeList = new ArrayList<>();
		treeNodeList.add(node.val);
		while (!q.isEmpty()) {
			TreeNode nowNode = q.poll();
			TreeNode leftNode = nowNode.left;
			TreeNode rightNode = nowNode.right;
			if (Objects.isNull(leftNode)) {
				treeNodeList.add(-1);
			} else {
				treeNodeList.add(leftNode.val);
				q.add(leftNode);
			}
			if (Objects.isNull(rightNode)) {
				treeNodeList.add(-1);
			} else {
				treeNodeList.add(rightNode.val);
				q.add(rightNode);
			}
		}
		return treeNodeList;
	}

	public TreeNode deserialize(String data) {
		if (Objects.isNull(data) || data.length() == 0)
			return null;
		List<Integer> treeNodeList = getTreeNodeList(data);
		return getTreeFromNodeList(treeNodeList);
	}

	private TreeNode getTreeFromNodeList(List<Integer> treeNodeList) {
		int headValue = treeNodeList.get(0);
		TreeNode root = new TreeNode(headValue);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int ind = 0;
		while (!q.isEmpty()) {
			TreeNode nowNode = q.poll();
			int leftValue = treeNodeList.get(ind + 1);
			int rightValue = treeNodeList.get(ind + 2);
			ind += 2;
			if (leftValue != -1) {
				TreeNode leftNode = new TreeNode(leftValue);
				nowNode.left = leftNode;
				q.add(leftNode);
			}
			if (rightValue != -1) {
				TreeNode rightNode = new TreeNode(rightValue);
				nowNode.right = rightNode;
				q.add(rightNode);
			}
		}
		return root;
	}

	private List<Integer> getTreeNodeList(String data) {
		int ind = 0;
		List<Integer> treeNodeList = new ArrayList<>();
		while (ind < data.length()) {
			int nowNumber = -1;
			while (ind < data.length()) {
				char nowChar = data.charAt(ind++);
				if (nowChar == ',') {
					break;
				}
				if (nowNumber == -1) {
					nowNumber = (nowChar - '0');
				} else {
					nowNumber = (nowNumber * 10) + (nowChar - '0');
				}
			}
			treeNodeList.add(nowNumber);
		}
		treeNodeList.add(-1);
		return treeNodeList;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}