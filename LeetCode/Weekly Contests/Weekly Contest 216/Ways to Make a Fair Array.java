
class Solution {
	public int waysToMakeFair(int[] nums) {

		int n = nums.length;
		int oddIndexCumSum[] = new int[n + 10];
		int evenIndexCumSum[] = new int[n + 10];
		oddIndexCumSum[n] = evenIndexCumSum[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (i % 2 == 0)
				evenIndexCumSum[i] = nums[i];
			else
				oddIndexCumSum[i] = nums[i];

			oddIndexCumSum[i] += oddIndexCumSum[i + 1];
			evenIndexCumSum[i] += evenIndexCumSum[i + 1];
		}
		int ansCount = 0;
		int nowOddCumSum = 0;
		int nowEvenCumSum = 0;
		for (int i = 0; i < n; i++) {
			int tempOddSum = nowOddCumSum;
			int tempEvenSum = nowEvenCumSum;
			if (i % 2 == 0) {
				tempOddSum += evenIndexCumSum[i + 1];
				tempEvenSum += oddIndexCumSum[i + 1];
			} else {
				tempEvenSum += oddIndexCumSum[i + 1];
				tempOddSum += evenIndexCumSum[i + 1];
			}
			if (tempOddSum == tempEvenSum)
				ansCount++;
			if (i % 2 == 0)
				nowEvenCumSum += nums[i];
			else
				nowOddCumSum += nums[i];
		}
		return ansCount;
	}
}