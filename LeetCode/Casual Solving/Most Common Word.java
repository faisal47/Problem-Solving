package practice.problems;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Boolean> bannedWordsMap = new HashMap<>();
		for (int i = 0; i < banned.length; i++)
			if (!bannedWordsMap.containsKey(banned[i]))
				bannedWordsMap.put(banned[i], true);
		StringBuilder word = new StringBuilder();
		Map<String, Integer> wordCountMap = new HashMap<>();
		int ansCount = 0;
		String ansString = "";
		for (int i = 0; i < paragraph.length(); i++)
			if (Character.isLetter(paragraph.charAt(i)))
				word.append(paragraph.charAt(i));
			else {
				if (word.length() > 0) {
					String wordSt = word.toString().toLowerCase();
					if (!bannedWordsMap.containsKey(wordSt)) {
						if (wordCountMap.containsKey(wordSt))
							wordCountMap.put(wordSt, wordCountMap.get(wordSt) + 1);
						else
							wordCountMap.put(wordSt, 1);
						if (wordCountMap.get(wordSt) > ansCount) {
							ansCount = wordCountMap.get(wordSt);
							ansString = wordSt;
						}
					}
					word.setLength(0);
				}
			}
		if (word.length() > 0) {
			String wordSt = word.toString().toLowerCase();
			if (!bannedWordsMap.containsKey(wordSt)) {
				if (wordCountMap.containsKey(wordSt))
					wordCountMap.put(wordSt, wordCountMap.get(wordSt) + 1);
				else
					wordCountMap.put(wordSt, 1);
				if (wordCountMap.get(wordSt) > ansCount) {
					ansCount = wordCountMap.get(wordSt);
					ansString = wordSt;
				}
			}
			word.setLength(0);
		}
		return ansString;
	}
}