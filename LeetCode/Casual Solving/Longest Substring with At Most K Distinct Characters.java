package com.java.practice;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int nowDistinct = 0;
		int l = 0;
		int r = 0;
		int ans = 0;
		Map<Character, Integer> charCount = new HashMap<>();
		while (r < s.length()) {
			char nowChar = s.charAt(r++);
			if (!charCount.containsKey(nowChar))
				charCount.put(nowChar, 0);
			charCount.put(nowChar, charCount.get(nowChar) + 1);
			if (charCount.get(nowChar) == 1)
				nowDistinct++;
			while (nowDistinct > k) {
				nowChar = s.charAt(l++);
				charCount.put(nowChar, charCount.get(nowChar) - 1);
				if (charCount.get(nowChar) == 0)
					nowDistinct--;
			}
			ans = Math.max(ans, r - l);
		}
		return ans;
	}
}