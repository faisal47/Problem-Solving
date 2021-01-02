package com.java.practice;

class Solution {
	public int missingNumber(int[] nums) {
		int xorValue = 0;
		int n = nums.length;
		for (int i = 0; i <= n; i++)
			xorValue ^= i;
		for (int i = 0; i < n; i++)
			xorValue ^= nums[i];
		return xorValue;
	}
}