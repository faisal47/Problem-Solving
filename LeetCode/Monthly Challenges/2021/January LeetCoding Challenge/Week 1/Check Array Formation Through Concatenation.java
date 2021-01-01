package com.java.practice;

import java.util.Arrays;

class Solution {
	public boolean canFormArray(int[] arr, int[][] pieces) {

		int pos[] = new int[110];
		boolean formedFlag[] = new boolean[110];
		Arrays.fill(formedFlag, false);
		Arrays.fill(pos, -1);
		int n = arr.length;

		for (int i = 0; i < n; i++)
			pos[arr[i]] = i;

		for (int i = 0; i < pieces.length; i++) {
			int st = pos[pieces[i][0]];
			if (st == -1)
				return false;
			for (int j = 0; j < pieces[i].length; j++) {
				if (st + j >= n || pieces[i][j] != arr[st + j] || formedFlag[st + j])
					return false;
				formedFlag[st + j] = true;
			}
		}

		for (int i = 0; i < n; i++)
			if (!formedFlag[i])
				return false;

		return true;
	}
}