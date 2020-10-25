package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> ans = new ArrayList<>();
		for (int i = 0; i < l.length; i++) {
			ans.add(check(nums, l[i], r[i]));
		}
		return ans;
	}

	private Boolean check(int[] nums, int l, int r) {
		int n = r - l + 1;
		int arr[] = new int[n];
		int cnt = 0;
		for (int i = l; i <= r; i++)
			arr[cnt++] = nums[i];
		Arrays.sort(arr);
		int d = arr[1] - arr[0];
		for (int i = 2; i < n; i++)
			if (arr[i] - arr[i - 1] != d)
				return false;
		return true;
	}
}