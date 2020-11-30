package practice.problems;

import java.util.Arrays;

class Solution {
	int n;
	int dp[];

	public boolean canReach(int[] arr, int start) {
		pre(arr);
		return solve(start, arr) == 1;
	}

	private int solve(int ind, int[] arr) {

		if (arr[ind] == 0)
			return 1;

		int ret = dp[ind];

		if (ret != -1)
			return ret;

		dp[ind] = ret = 0;
		if (ind - arr[ind] >= 0)
			ret = Math.max(ret, solve(ind - arr[ind], arr));

		if (ind + arr[ind] < n)
			ret = Math.max(ret, solve(ind + arr[ind], arr));

		return dp[ind] = ret;
	}

	private void pre(int[] arr) {
		n = arr.length;
		dp = new int[n + 5];
		Arrays.fill(dp, -1);
	}
}