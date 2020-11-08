package practice.problems;

class Solution {
	public int twoSumLessThanK(int[] A, int K) {
		int ans = -1;
		for (int i = 0; i < A.length; i++)
			for (int j = i + 1; j < A.length; j++)
				if (A[i] + A[j] < K)
					ans = Math.max(A[i] + A[j], ans);
		return ans;
	}
}