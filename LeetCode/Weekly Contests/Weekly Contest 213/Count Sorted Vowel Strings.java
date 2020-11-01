package practice.problems;

class Solution {
	int dp[][];

	public int countVowelStrings(int n) {
		dp = new int[n][5];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 5; j++)
				dp[i][j] = -1;
		return solve(0, 0, n);
	}

	private int solve(int ind, int v, int n) {
		if (ind == n)
			return 1;
		int ret = dp[ind][v];
		if (ret != -1)
			return ret;
		ret = 0;
		for (int i = v; i < 5; i++)
			ret += solve(ind + 1, i, n);
		return dp[ind][v] = ret;
	}
}