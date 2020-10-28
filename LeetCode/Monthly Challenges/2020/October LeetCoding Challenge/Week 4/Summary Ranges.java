package practice.problems;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> ansList = new ArrayList<>();
		if (nums.length == 0)
			return ansList;
		int l = nums[0];
		int r = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 1) {
				r = nums[i];
			} else {
				ansList.add(getRange(l, r));
				l = r = nums[i];
			}
		}
		ansList.add(getRange(l, r));
		return ansList;
	}

	private String getRange(int l, int r) {
		if (l == r)
			return Integer.valueOf(l).toString();
		return Integer.valueOf(l).toString() + "->" + Integer.valueOf(r).toString();
	}
}