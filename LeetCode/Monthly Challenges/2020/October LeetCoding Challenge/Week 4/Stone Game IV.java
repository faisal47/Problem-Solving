package practice.problems;

class Solution {
	public boolean winnerSquareGame(int n) {
		int dp[][] = new int[n + 2][2];
		for (int i = 0; i < n + 1; i++)
			dp[i][0] = dp[i][1] = -1;
		return solve(n, 0, dp) == 1;
	}

	private int solve(int n, int pl, int dp[][]) {
		if (n == 0)
			return pl;
		int val = dp[n][pl];
		if (val != -1)
			return val;
		val = pl;
		for (int i = 1; i * i <= n; i++) {
			if (pl == 1) {
				val = Math.min(val, solve(n - i * i, 0, dp));
				if (val == 0)
					break;
			} else {
				val = Math.max(val, solve(n - i * i, 1, dp));
				if (val == 1)
					break;
			}
		}
		return dp[n][pl] = val;
	}
}