
import java.util.ArrayList;
import java.util.List;

class Solution {
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		if (k == 0)
			return;
		int posStart = nums.length - k;
		List<Integer> newNums = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			newNums.add(nums[posStart++]);
			posStart %= nums.length;
		}
		for (int i = 0; i < nums.length; i++)
			nums[i] = newNums.get(i);
	}
}