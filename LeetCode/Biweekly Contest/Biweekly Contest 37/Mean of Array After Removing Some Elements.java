package practice.problems;

import java.util.Arrays;

class Solution {
	public double trimMean(int[] arr) {
		double totSum = 0;
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			double percentageIndex = (double) (i + 1) * (double) 100 / (double) arr.length;
			if (percentageIndex > (double) 5 && percentageIndex <= (double) 95) {
				cnt++;
				// if (percentageIndex > 80)
				// System.out.println(percentageIndex + " " + i + 1);
				totSum += arr[i];
			}
		}
		return (totSum / (double) cnt);
	}
}