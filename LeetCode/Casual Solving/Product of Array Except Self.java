package com.java.practice;

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int output[] = new int[n];
		output[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--)
			output[i] = output[i + 1] * nums[i];
		int prefixMul = 1;
		for (int i = 0; i < n - 1; i++) {
			output[i] = output[i + 1] * prefixMul;
			prefixMul *= nums[i];
		}
		output[n - 1] = prefixMul;
		return output;
	}
}