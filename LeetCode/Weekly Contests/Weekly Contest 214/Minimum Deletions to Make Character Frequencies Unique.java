package practice.problems;

import java.util.Arrays;

class Solution {
	public int minDeletions(String s) {
		int letterCount[] = new int[26];
		Arrays.fill(letterCount, 0);
		for (int i = 0; i < s.length(); i++)
			letterCount[s.charAt(i) - 'a']++;

		int freqCount[] = new int[100005];
		Arrays.fill(freqCount, 0);
		for (int i = 0; i < 26; i++)
			freqCount[letterCount[i]]++;
		int ans = 0;
		for (int i = 100000; i >= 1; i--) {
			if (freqCount[i] > 1) {
				ans += (freqCount[i] - 1);
				freqCount[i - 1] += (freqCount[i] - 1);
			}
		}
		return ans;
	}
}