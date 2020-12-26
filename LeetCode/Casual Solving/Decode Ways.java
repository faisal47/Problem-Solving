package com.java.practice;

import java.util.Arrays;

class Solution {
	public int numDecodings(String s) {
		int dp[] = new int[110];
		Arrays.fill(dp, -1);
		return solve(0, s, dp);
	}

	private int solve(int ind, String s, int[] dp) {
		if (ind >= s.length())
			return 1;
		if (dp[ind] != -1)
			return dp[ind];
		dp[ind] = 0;
		if (s.charAt(ind) > '0')
			dp[ind] = solve(ind + 1, s, dp);
		if (ind + 1 < s.length() && s.charAt(ind) > '0') {
			int num = ((s.charAt(ind) - '0') * 10) + (s.charAt(ind + 1) - '0');
			if (num >= 1 && num <= 26)
				dp[ind] += solve(ind + 2, s, dp);
		}
		return dp[ind];
	}
}