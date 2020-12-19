class Solution {
	public int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int rightIndex = getRightIndex(numbers, i + 1, numbers.length - 1, target - numbers[i]);
			if (rightIndex != -1) {
				int ansArr[] = { i + 1, rightIndex + 1 };
				return ansArr;
			}

		}
		return new int[2];
	}

	private int getRightIndex(int[] numbers, int l, int r, int restTarget) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (numbers[mid] == restTarget)
				return mid;
			if (numbers[mid] > restTarget)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return -1;
	}
}