package practice.problems;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int l = 0;
		int r = 0;
		int ans = 0;
		Map<Character, Integer> charCountMap = new HashMap<>();
		while (r < s.length()) {
			char nowChar = s.charAt(r++);
			if (charCountMap.containsKey(nowChar))
				charCountMap.put(nowChar, charCountMap.get(nowChar) + 1);
			else
				charCountMap.put(nowChar, 1);
			while (charCountMap.size() > 2) {
				char toRemoveChar = s.charAt(l++);
				charCountMap.put(toRemoveChar, charCountMap.get(toRemoveChar) - 1);
				if (charCountMap.get(toRemoveChar) == 0)
					charCountMap.remove(toRemoveChar);
			}
			ans = Math.max(ans, r - l);
		}
		return ans;
	}
}