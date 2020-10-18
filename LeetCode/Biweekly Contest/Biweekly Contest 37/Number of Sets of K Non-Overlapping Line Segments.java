package practice.problems;

class Solution {
	int dp[][][];
	final int mod = 1000000007;

	public int numberOfSets(int n, int k) {
		dp = new int[n + 2][k + 2][2];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < k + 1; j++)
				dp[i][j][0] = dp[i][j][1] = -1;
		return solve(0, k, 0, n);
	}

	private int solve(int ind, int k, int oc, int n) {
		if (k == 0)
			return 1;
		if (ind == n)
			return 0;
		int ret = dp[ind][k][oc];
		if (ret != -1)
			return ret;
		ret = 0;
		if (oc == 1) {
			ret = (ret + solve(ind, k - 1, 0, n)) % mod;
		} else {
			ret = (ret + solve(ind + 1, k, 1, n)) % mod;
		}
		ret = (ret + solve(ind + 1, k, oc, n)) % mod;
		return dp[ind][k][oc] = ret;
	}
}