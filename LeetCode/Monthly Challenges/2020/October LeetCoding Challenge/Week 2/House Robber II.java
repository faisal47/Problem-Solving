
class Solution {

	public int rob(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n + 2][2];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2; j++)
				dp[i][j] = -1;
		return solve(0, 0, dp, n, nums);
	}

	private int solve(int ind, int firstIndexTaken, int[][] dp, int n, int[] nums) {
		if (ind == n - 1) {
			return firstIndexTaken == 0 ? nums[ind] : 0;
		}
		if (ind >= n)
			return 0;
		int ret = dp[ind][firstIndexTaken];
		if (ret != -1)
			return ret;
		ret = 0;
		ret = Math.max(ret, solve(ind + 1, firstIndexTaken, dp, n, nums));
		if (ind == 0) {
			ret = Math.max(ret, nums[ind] + solve(ind + 2, 1, dp, n, nums));
		} else {
			ret = Math.max(ret, nums[ind] + solve(ind + 2, firstIndexTaken, dp, n, nums));
		}
		return dp[ind][firstIndexTaken] = ret;
	}
}