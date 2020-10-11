package practice.problems;

import java.util.Stack;

class Solution {
	public int maxDepth(String s) {
		Stack<Character> st = new Stack<>();
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			char nowch = s.charAt(i);
			if (nowch == '(' || nowch == ')') {
				if (nowch == '(') {
					st.add(nowch);
					ret = Math.max(ret, st.size());
				} else {
					st.pop();
				}
			}
		}
		return ret;
	}
}