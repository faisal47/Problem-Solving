
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int minMeetingRooms(int[][] intervals) {
		List<Integer> uniqueNumbers = new ArrayList<>();
		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			intervals[i][1]--;
			numberAddedCheck(uniqueNumbers, numberMap, intervals[i][0]);
			numberAddedCheck(uniqueNumbers, numberMap, intervals[i][1]);
		}
		Collections.sort(uniqueNumbers);
		for (int i = 0; i < uniqueNumbers.size(); i++)
			numberMap.put(uniqueNumbers.get(i), i);
		int cumSum[] = new int[uniqueNumbers.size() + 10];
		Arrays.fill(cumSum, 0);
		for (int i = 0; i < intervals.length; i++) {
			cumSum[numberMap.get(intervals[i][0])]++;
			cumSum[numberMap.get(intervals[i][1]) + 1]--;
		}
		int minMeetingRooms = 0;
		for (int i = 0; i < uniqueNumbers.size() + 2; i++) {
			if (i > 0)
				cumSum[i] += cumSum[i - 1];
			minMeetingRooms = Math.max(minMeetingRooms, cumSum[i]);
		}
		return minMeetingRooms;
	}

	private void numberAddedCheck(List<Integer> uniqueNumbers, Map<Integer, Integer> numberMap, int nowNumber) {
		if (!numberMap.containsKey(nowNumber)) {
			uniqueNumbers.add(nowNumber);
			numberMap.put(nowNumber, 0);
		}
	}
}