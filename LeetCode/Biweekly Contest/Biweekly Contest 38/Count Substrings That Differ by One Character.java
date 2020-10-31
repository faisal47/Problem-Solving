package practice.problems;

class Solution {
	public int countSubstrings(String s, String t) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++)
			for (int j = i; j < s.length(); j++)
				ans += countSubStr(s.substring(i, j + 1), t);
		return ans;
	}

	private int countSubStr(String subS, String t) {
		if (t.length() < subS.length())
			return 0;
		int cnt = 0;
		StringBuilder tStBuild = new StringBuilder();
		for (int i = 0; i < t.length(); i++) {
			tStBuild.append(t.charAt(i));
			if (tStBuild.length() == subS.length()) {
				cnt += calculateDist(subS, tStBuild.toString()) == 1 ? 1 : 0;
				tStBuild.deleteCharAt(0);
			}
		}
		return cnt;
	}

	private int calculateDist(String subS, String subT) {
		int dist = 0;
		for (int i = 0; i < subS.length(); i++) {
			if (subS.charAt(i) != subT.charAt(i))
				dist++;
			if (dist > 1)
				return dist;
		}
		return dist;
	}
}