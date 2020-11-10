package practice.problems;

class Solution {
	public int[][] flipAndInvertImage(int[][] A) {
		int n = A.length;
		int ans[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			int index = 0;
			for (int j = n - 1; j >= 0; j--)
				ans[i][index++] = A[i][j] ^ 1;
		}
		return ans;
	}
}