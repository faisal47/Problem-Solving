package practice.problems;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int minimumEffortPath(int[][] heights) {
		int n = heights.length;
		int m = heights[0].length;
		return bfs(heights, n, m);
	}

	int X[] = { -1, 1, 0, 0 };
	int Y[] = { 0, 0, -1, 1 };

	private int bfs(int[][] heights, int n, int m) {
		int maxiDiffInPath[][] = new int[n + 2][m + 2];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				maxiDiffInPath[i][j] = 1000005;
			}
		maxiDiffInPath[0][0] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(0);
		q.add(0);
		while (!q.isEmpty()) {
			int u = q.poll();
			int v = q.poll();
			int diff = q.poll();
			for (int i = 0; i < 4; i++) {
				int u2 = u + X[i];
				int v2 = v + Y[i];
				if (!validPoint(u2, v2, n, m))
					continue;

				int nowDist = Math.abs(heights[u][v] - heights[u2][v2]);

				if (Math.max(diff, nowDist) < maxiDiffInPath[u2][v2]) {
					maxiDiffInPath[u2][v2] = Math.max(diff, nowDist);
					q.add(u2);
					q.add(v2);
					q.add(maxiDiffInPath[u2][v2]);
				}
			}
		}
		return maxiDiffInPath[n - 1][m - 1];
	}

	private boolean validPoint(int u2, int v2, int n, int m) {
		return u2 >= 0 && v2 >= 0 && u2 < n && v2 < m;
	}
}