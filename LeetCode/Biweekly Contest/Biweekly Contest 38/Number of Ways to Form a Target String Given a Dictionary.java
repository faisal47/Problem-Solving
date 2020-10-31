package practice.problems;

class Solution {
	int dp[][];
	final static int mod = 1000000007;
	int wordCharFreq[][];

	public int numWays(String[] words, String target) {
		dp = new int[target.length() + 2][words[0].length() + 2];
		wordCharFreq = new int[words[0].length()][26];
		for (int i = 0; i < target.length(); i++)
			for (int j = 0; j < words[0].length(); j++)
				dp[i][j] = -1;
		for (int i = 0; i < words[0].length(); i++)
			for (int j = 0; j < 26; j++)
				wordCharFreq[i][j] = 0;
		for (int i = 0; i < words[0].length(); i++)
			for (int j = 0; j < words.length; j++)
				wordCharFreq[i][words[j].charAt(i) - 'a']++;
		return solve(0, 0, target);
	}

	private int solve(int targetIndex, int wordIndex, String target) {
		if (targetIndex >= target.length())
			return 1;
		if (wordIndex >= wordCharFreq.length)
			return 0;
		int ret = dp[targetIndex][wordIndex];
		if (ret != -1)
			return ret;
		ret = solve(targetIndex, wordIndex + 1, target);

		if (wordCharFreq[wordIndex][target.charAt(targetIndex) - 'a'] > 0) {
			ret = (ret + (int) ((long) (wordCharFreq[wordIndex][target.charAt(targetIndex) - 'a']
					* (long) solve(targetIndex + 1, wordIndex + 1, target)) % (long) mod)) % mod;
		}
		return dp[targetIndex][wordIndex] = ret;
	}
}