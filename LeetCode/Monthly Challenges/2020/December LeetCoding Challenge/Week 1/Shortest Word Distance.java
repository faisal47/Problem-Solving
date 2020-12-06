package practice.problems;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int shortestDistance(String[] words, String word1, String word2) {
		List<Integer> word1Pos = new ArrayList<>();
		List<Integer> word2Pos = new ArrayList<>();
		for (int i = 0; i < words.length; i++)
			if (words[i].equals(word1))
				word1Pos.add(i);
			else if (words[i].equals(word2))
				word2Pos.add(i);
		int ans = words.length + 10;
		for (int i = 0; i < word1Pos.size(); i++)
			for (int j = 0; j < word2Pos.size(); j++)
				ans = Math.min(ans, Math.abs(word1Pos.get(i) - word2Pos.get(j)));
		return ans;
	}
}