package practice.problems;

class Solution {
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int ansTime = releaseTimes[0];
		char ansChar = keysPressed.charAt(0);
		for (int i = 1; i < releaseTimes.length; i++) {
			int nowTime = releaseTimes[i] - releaseTimes[i - 1];
			if (nowTime == ansTime)
				ansChar = (char) Math.max(ansChar, keysPressed.charAt(i));
			else if (nowTime > ansTime) {
				ansTime = nowTime;
				ansChar = keysPressed.charAt(i);
			}
		}
		return ansChar;
	}
}