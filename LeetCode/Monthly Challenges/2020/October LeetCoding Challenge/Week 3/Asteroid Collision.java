package practice.problems;

import java.util.Stack;

class Solution {
	public int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < asteroids.length; i++) {
			boolean flag = true;
			int nowAst = asteroids[i];
			while (!st.empty()) {
				if (st.peek() > 0 && nowAst < 0) {
					if (st.peek() + nowAst == 0) {
						flag = false;
						st.pop();
						break;
					} else if (st.peek() < Math.abs(nowAst)) {
						st.pop();
					} else {
						flag = false;
						break;
					}
				} else {
					break;
				}
			}
			if (flag)
				st.add(nowAst);
		}

		int res[] = new int[st.size()];
		for (int i = 0; i < st.size(); i++)
			res[i] = st.get(i);
		return res;
	}
}