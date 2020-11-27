package practice.problems;

import java.util.Arrays;

class Solution {
	int freq[];
	int dp[][];

	public boolean canPartition(int[] nums) {
		int totSum = 0;
		freq = new int[105];
		Arrays.fill(freq, 0);
		for (int i = 0; i < nums.length; i++) {
			totSum += nums[i];
			freq[nums[i]]++;
		}
		if (totSum % 2 == 1)
			return false;
		int halfSum = totSum / 2;
		dp = new int[105][halfSum + 5];
		for (int i = 0; i < 105; i++)
			for (int j = 0; j < halfSum + 5; j++)
				dp[i][j] = -1;
		return solve(1, halfSum) == 1;
	}

	private int solve(int nowNum, int sum) {
		if (sum == 0)
			return 1;
		if (nowNum > 100 || sum < 0)
			return 0;
		int ret = dp[nowNum][sum];
		if (ret != -1)
			return ret;
		ret = solve(nowNum + 1, sum);
		for (int i = 1; i <= freq[nowNum]; i++) {
			ret = Math.max(ret, solve(nowNum + 1, sum - (i * nowNum)));
			if (ret == 1)
				break;
		}
		return dp[nowNum][sum] = ret;
	}
}