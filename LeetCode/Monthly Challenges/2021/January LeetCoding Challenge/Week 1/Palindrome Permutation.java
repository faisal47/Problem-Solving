package com.java.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < s.length(); i++)
			if (charCount.containsKey(s.charAt(i)))
				charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
			else
				charCount.put(s.charAt(i), 1);
		int oddCount = 0;
		for (Entry<Character, Integer> charCountEntry : charCount.entrySet())
			if (charCountEntry.getValue() % 2 == 1)
				oddCount++;
		return oddCount < 2;
	}
}