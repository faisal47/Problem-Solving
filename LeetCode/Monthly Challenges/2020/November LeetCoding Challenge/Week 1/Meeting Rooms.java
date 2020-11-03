package practice.problems;

import java.util.Arrays;

class Solution {
	int meetingCountAtATime[];

	public boolean canAttendMeetings(int[][] intervals) {
		meetingCountAtATime = new int[1000020];
		Arrays.fill(meetingCountAtATime, 0);
		for (int i = 0; i < intervals.length; i++) {
			meetingCountAtATime[intervals[i][0]]++;
			meetingCountAtATime[intervals[i][1]]--;
		}
		for (int i = 0; i < 1000005; i++) {
			if (i > 0)
				meetingCountAtATime[i] += meetingCountAtATime[i - 1];
			if (meetingCountAtATime[i] > 1)
				return false;
		}
		return true;
	}
}