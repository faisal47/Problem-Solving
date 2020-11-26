package practice.problems;

import java.util.Arrays;

class Solution {
	public int longestSubstring(String s, int k) {
		int maxLength = 0;
		int charCount[] = new int[26];
		Arrays.fill(charCount, 0);
		for (int i = 0; i < s.length(); i++)
			charCount[s.charAt(i) - 'a']++;
		int st = 0;
		int en = 0;
		boolean validSubstr = true;
		while (en < s.length()) {
			if (charCount[s.charAt(en) - 'a'] < k) {
				validSubstr = false;
				if (en > st)
					maxLength = Math.max(maxLength, longestSubstring(s.substring(st, en), k));
				st = en + 1;
			}
			en++;
		}
		if (validSubstr)
			return s.length();
		return Math.max(maxLength, longestSubstring(s.substring(st), k));
	}
}