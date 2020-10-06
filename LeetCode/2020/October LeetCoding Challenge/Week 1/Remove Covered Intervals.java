
import java.util.Arrays;
import java.util.Comparator;

class IntervalComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[0] == o2[0])
			return o1[1] - o2[1];
		return o1[0] - o2[0];
	}
}

class Solution {
	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		int cutOffCount = 0;
		int left = intervals[0][0];
		int right = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int nowLeft = intervals[i][0];
			int nowRight = intervals[i][1];
			if (nowLeft >= left && nowRight <= right)
				cutOffCount++;
			else if (left >= nowLeft && right <= nowRight) {
				cutOffCount++;
				left = nowLeft;
				right = nowRight;
			} else {
				left = nowLeft;
				right = nowRight;
			}
		}
		return intervals.length - cutOffCount;
	}
}