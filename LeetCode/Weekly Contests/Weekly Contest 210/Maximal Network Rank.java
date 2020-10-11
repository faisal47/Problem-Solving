package practice.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public int maximalNetworkRank(int n, int[][] roads) {
		int ret = 0;
		List<List<Integer>> nodeRoads = new ArrayList<>();
		for (int i = 0; i < n; i++)
			nodeRoads.add(new ArrayList<>());
		for (int i = 0; i < roads.length; i++) {
			int a = roads[i][0];
			int b = roads[i][1];
			nodeRoads.get(a).add(i);
			nodeRoads.get(b).add(i);
		}
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				Set<Integer> ss = new HashSet<>();
				for (int k = 0; k < nodeRoads.get(i).size(); k++)
					ss.add(nodeRoads.get(i).get(k));
				for (int k = 0; k < nodeRoads.get(j).size(); k++)
					ss.add(nodeRoads.get(j).get(k));
				ret = Math.max(ret, ss.size());
			}
		return ret;
	}
}