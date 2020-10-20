package practice.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

class Solution {
	public Node cloneGraph(Node node) {
		if (Objects.isNull(node))
			return null;
		Node newHead = new Node(node.val);
		Map<Integer, Node> nodesMap = new HashMap<>();
		nodesMap.put(newHead.val, newHead);
		buildClonedGraph(node, newHead, nodesMap);
		return newHead;
	}

	private void buildClonedGraph(Node node, Node newHead, Map<Integer, Node> nodesMap) {

		Queue<Node> nodesQueue = new LinkedList<>();
		Queue<Node> nodesQueueForCloned = new LinkedList<>();

		nodesQueue.add(node);
		nodesQueueForCloned.add(newHead);

		while (!nodesQueue.isEmpty()) {

			Node nowNode = nodesQueue.poll();
			Node nowNodeForCloned = nodesQueueForCloned.poll();

			List<Node> nowNodeNeighbors = nowNode.neighbors;

			for (int i = 0; i < nowNodeNeighbors.size(); i++) {

				Node neighborNode = nowNodeNeighbors.get(i);

				if (!nodesMap.containsKey(neighborNode.val)) {
					nodesQueue.add(neighborNode);
					Node neighborNodeCloned = new Node(neighborNode.val);
					nodesQueueForCloned.add(neighborNodeCloned);
					nodesMap.put(neighborNodeCloned.val, neighborNodeCloned);
				}
				nowNodeForCloned.neighbors.add(nodesMap.get(neighborNode.val));
			}
		}
	}
}