package practice.problems;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		int ans = 0;
		int l = 0;
		int h = heights.length - 1;
		while (l <= h) {
			int mid = l + h >> 1;
			if (reachable(mid, heights, bricks, ladders)) {
				ans = Math.max(ans, mid);
				l = mid + 1;
			} else
				h = mid - 1;
		}
		return ans;
	}

	private boolean reachable(int mid, int[] heights, int bricks, int ladders) {
		List<Integer> brickDiffs = new ArrayList<>();
		for (int i = 1; i <= mid; i++)
			if (heights[i] > heights[i - 1])
				brickDiffs.add(heights[i] - heights[i - 1]);
		brickDiffs.sort((o1, o2) -> {
			return o2.compareTo(o1);
		});
		for (int i = 0; i < brickDiffs.size(); i++) {
			if (ladders > 0) {
				ladders--;
				continue;
			}
			if (brickDiffs.get(i) > bricks)
				return false;
			bricks -= brickDiffs.get(i);
		}
		return true;
	}
}