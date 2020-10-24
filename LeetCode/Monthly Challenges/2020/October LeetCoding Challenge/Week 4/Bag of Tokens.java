package practice.problems;

import java.util.Arrays;

class Solution {
	public int bagOfTokensScore(int[] tokens, int P) {
		Arrays.sort(tokens);
		int l = 0;
		int r = tokens.length - 1;
		int nowScore = 0;
		while (l <= r) {
			if (tokens[l] <= P) {
				P -= tokens[l++];
				nowScore++;
			} else if (nowScore > 0 && r - l > 0) {
				P += tokens[r--];
				nowScore--;
			} else
				break;
		}
		return nowScore;
	}
}