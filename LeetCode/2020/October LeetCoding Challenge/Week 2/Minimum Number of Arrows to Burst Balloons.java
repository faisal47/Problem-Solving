import java.util.Arrays;

class Solution {
	public int findMinArrowShots(int[][] points) {
		int arrowShots = 0;
		Arrays.sort(points, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		int right = 0;
		for (int i = 0; i < points.length; i++) {
			if (i == 0) {
				right = points[i][1];
				arrowShots = 1;
			} else {
				if (points[i][0] > right) {
					right = points[i][1];
					arrowShots++;
				} else {
					right = Math.min(right, points[i][1]);
				}
			}
		}
		return arrowShots;
	}
}