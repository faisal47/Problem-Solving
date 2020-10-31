package practice.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class NumFreqCount {
	int num;
	int freq;

	public NumFreqCount(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}

class NumfreqComparator implements Comparator<NumFreqCount> {

	@Override
	public int compare(NumFreqCount o1, NumFreqCount o2) {
		if (o1.freq == o2.freq)
			return o2.num - o1.num;
		return o1.freq - o2.freq;
	}

}

class Solution {
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> numsFreqMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			if (numsFreqMap.containsKey(nums[i]))
				numsFreqMap.put(nums[i], numsFreqMap.get(nums[i]) + 1);
			else
				numsFreqMap.put(nums[i], 1);
		List<NumFreqCount> numFreqCounts = new ArrayList<>();
		for (Entry<Integer, Integer> numFreq : numsFreqMap.entrySet())
			numFreqCounts.add(new NumFreqCount(numFreq.getKey(), numFreq.getValue()));
		numFreqCounts.sort(new NumfreqComparator());
		int res[] = new int[nums.length];
		int ind = 0;
		for (int i = 0; i < numFreqCounts.size(); i++) {
			NumFreqCount numFreqCount = numFreqCounts.get(i);
			while (numFreqCount.freq > 0) {
				res[ind++] = numFreqCount.num;
				numFreqCount.freq--;
			}
		}
		return res;
	}
}