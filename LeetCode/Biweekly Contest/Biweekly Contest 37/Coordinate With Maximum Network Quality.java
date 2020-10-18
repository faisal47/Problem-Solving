package practice.problems;

class Solution {
	public int[] bestCoordinate(int[][] towers, int radius) {
		int ans[] = new int[2];
		int power = 0;
		for (int i = 0; i <= 50; i++)
			for (int j = 0; j <= 50; j++) {
				int nowTotPower = 0;
				for (int k = 0; k < towers.length; k++)
					nowTotPower += calculatePower(i, j, towers[k], radius);
				if (nowTotPower > power) {
					power = nowTotPower;
					ans[0] = i;
					ans[1] = j;
				}
			}
		return ans;
	}

	private int calculatePower(int i, int j, int[] tower, int radius) {
		int d = calculateDistance(i, j, tower[0], tower[1]);
		if (d > radius * radius)
			return 0;
		return (int) (tower[2] / (1 + Math.sqrt(d)));
	}

	private int calculateDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2);
	}
}