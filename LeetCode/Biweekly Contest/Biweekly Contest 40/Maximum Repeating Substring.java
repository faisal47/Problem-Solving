package practice.problems;

class Solution {
	public int maxRepeating(String sequence, String word) {
		int ans = 0;
		StringBuilder wordSb = new StringBuilder(word);
		int k = 1;
		while (wordSb.length() <= sequence.length()) {
			if (sequence.contains(wordSb.toString()))
				ans = k;
			k++;
			wordSb.append(word);
		}
		return ans;
	}
}