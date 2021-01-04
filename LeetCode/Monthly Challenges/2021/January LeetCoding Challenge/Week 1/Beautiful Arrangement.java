package com.java.practice;

import java.util.Arrays;

class Solution {
	int dp[][];

	public int countArrangement(int n) {
		pre(n);
		return solve(0, 0, n);
	}

	private int solve(int ind, int mask, int n) {
		if (ind == n)
			return 1;
		if (dp[ind][mask] != -1)
			return dp[ind][mask];
		int ret = 0;
		for (int i = 0; i < n; i++)
			if ((mask & (1 << i)) == 0 && ((i + 1) % (ind + 1) == 0 || (ind + 1) % (i + 1) == 0))
				ret += solve(ind + 1, mask | (1 << i), n);

		return dp[ind][mask] = ret;
	}

	private void pre(int n) {
		dp = new int[n][32770];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
	}
}