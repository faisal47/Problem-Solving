
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxOperations(int[] nums, int k) {
		int ans = 0;
		Map<Integer, Integer> numCount = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			if (numCount.containsKey(nums[i]))
				numCount.put(nums[i], numCount.get(nums[i]) + 1);
			else
				numCount.put(nums[i], 1);
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			int b = k - nums[i];
			if (numCount.containsKey(a) && numCount.containsKey(b)) {
				if (a == b && numCount.get(a) >= 2) {
					ans++;
				} else if (a != b)
					ans++;
				numCount.put(a, numCount.get(a) - 1);
				numCount.put(b, numCount.get(b) - 1);
				if (numCount.containsKey(a) && numCount.get(a) <= 0)
					numCount.remove(a);
				if (numCount.containsKey(b) && numCount.get(b) <= 0)
					numCount.remove(b);
			}
		}
		return ans;
	}
}