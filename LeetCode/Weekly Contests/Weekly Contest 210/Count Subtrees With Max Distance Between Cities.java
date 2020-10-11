package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
		int ans[] = new int[n - 1];
		Arrays.fill(ans, 0);
		int mask = (1 << n);
		while (mask > 0) {
			mask--;
			List<List<Integer>> tree = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				tree.add(new ArrayList<>());
			}
			List<Integer> nodes = new ArrayList<>();
			for (int i = 0; i < n; i++)
				if ((mask & (1 << i)) > 0)
					nodes.add(i);
			for (int i = 0; i < edges.length; i++) {
				int a = edges[i][0] - 1;
				int b = edges[i][1] - 1;
				if ((mask & (1 << a)) > 0 && (mask & (1 << b)) > 0) {
					tree.get(a).add(b);
					tree.get(b).add(a);
				}
			}
			if (validTree(tree, nodes)) {
				// System.out.println("nodes -> " + nodes);
				ans[getMaxDist(tree, nodes) - 1]++;
			}
		}
		return ans;
	}

	private int getMaxDist(List<List<Integer>> tree, List<Integer> nodes) {
		int maxDistNode = getMaxDistNode(nodes.get(0), tree);
		return getMaxDist(maxDistNode, tree);
	}

	private int getMaxDist(int node, List<List<Integer>> tree) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		boolean col[] = new boolean[20];
		int dist[] = new int[20];
		Arrays.fill(col, false);
		col[node] = true;
		dist[node] = 0;
		int ans = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int i = 0; i < tree.get(a).size(); i++) {
				int b = tree.get(a).get(i);
				if (!col[b]) {
					q.add(b);
					col[b] = true;
					dist[b] = dist[a] + 1;
					ans = dist[b];
				}
			}
		}
		return ans;
	}

	private int getMaxDistNode(Integer node, List<List<Integer>> tree) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		boolean col[] = new boolean[20];
		Arrays.fill(col, false);
		col[node] = true;
		int ans = node;
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int i = 0; i < tree.get(a).size(); i++) {
				int b = tree.get(a).get(i);
				if (!col[b]) {
					q.add(b);
					col[b] = true;
					ans = b;
				}
			}
		}
		return ans;
	}

	private boolean validTree(List<List<Integer>> tree, List<Integer> nodes) {
		// System.out.println("validTree-> " + nodes);
		if (nodes.size() < 2)
			return false;
		return isConnected(nodes, tree);
	}

	private boolean isConnected(List<Integer> nodes, List<List<Integer>> tree) {
		// System.out.println("isConnected -> " + nodes);
		int totFound = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(nodes.get(0));
		boolean col[] = new boolean[20];
		Arrays.fill(col, false);
		col[nodes.get(0)] = true;
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int i = 0; i < tree.get(a).size(); i++) {
				int b = tree.get(a).get(i);
				if (!col[b]) {
					totFound++;
					q.add(b);
					col[b] = true;
				}
			}
		}
		return totFound == nodes.size();
	}
}