package com.java.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNumAndPos {
	int num;
	int x;
	int y;

	TreeNumAndPos(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Solution {
	public int cutOffTree(List<List<Integer>> forest) {

		List<TreeNumAndPos> treeNumAndPoses = getTreeNumPos(forest);
		treeNumAndPoses.sort((a, b) -> {
			return a.num - b.num;
		});

		int cutOffTreeValue = 0;
		int nowX = 0;
		int nowY = 0;

		for (int i = 0; i < treeNumAndPoses.size(); i++) {
			TreeNumAndPos treeNumAndPos = treeNumAndPoses.get(i);
			int dist = bfs(nowX, nowY, treeNumAndPos.x, treeNumAndPos.y, forest);
			if (dist == -1)
				return -1;
			cutOffTreeValue += dist;
			nowX = treeNumAndPos.x;
			nowY = treeNumAndPos.y;
		}
		return cutOffTreeValue;
	}

	private int bfs(int x, int y, int destX, int destY, List<List<Integer>> forest) {
		// System.out.println("bfs start " + x + " " + y + " " + destX + " " + destY);
		int X[] = { -1, 1, 0, 0 };
		int Y[] = { 0, 0, -1, 1 };
		int dist[][] = new int[55][55];
		for (int i = 0; i < 55; i++)
			for (int j = 0; j < 55; j++)
				dist[i][j] = -1;

		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		q.add(y);

		dist[x][y] = 0;

		while (!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			if (x == destX && y == destY)
				return dist[x][y];
			for (int i = 0; i < 4; i++) {
				int u = X[i] + x;
				int v = Y[i] + y;
				if (validAndNotVisited(dist, u, v, forest, forest.size(), forest.get(0).size())) {
					// System.out.println(x + " " + y + " " + u + " " + v);
					dist[u][v] = 1 + dist[x][y];
					q.add(u);
					q.add(v);
				}

			}
		}
		return -1;
	}

	private boolean validAndNotVisited(int[][] dist, int u, int v, List<List<Integer>> forest, int n, int m) {
		return u >= 0 && u < n && v >= 0 && v < m && dist[u][v] == -1 && forest.get(u).get(v) != 0;
	}

	private List<TreeNumAndPos> getTreeNumPos(List<List<Integer>> forest) {

		List<TreeNumAndPos> treeNumAndPoses = new ArrayList<>();

		for (int i = 0; i < forest.size(); i++)
			for (int j = 0; j < forest.get(i).size(); j++)
				if (forest.get(i).get(j) > 1)
					treeNumAndPoses.add(new TreeNumAndPos(forest.get(i).get(j), i, j));

		return treeNumAndPoses;
	}
}