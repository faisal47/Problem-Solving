
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int findPairs(int[] nums, int k) {
		int ansCount = 0;
		Map<Integer, Integer> hasInNums = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hasInNums.containsKey(nums[i]))
				hasInNums.put(nums[i], hasInNums.get(nums[i]) + 1);
			else
				hasInNums.put(nums[i], 1);
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int b = k + nums[i];
			if (k == 0) {
				if (hasInNums.get(nums[i]) > 1)
					ansCount++;
			} else if (hasInNums.containsKey(b))
				ansCount++;
		}

		return ansCount;
	}
}