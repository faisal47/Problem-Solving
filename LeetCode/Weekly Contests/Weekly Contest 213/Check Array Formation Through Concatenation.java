package practice.problems;

class Solution {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			int startInd = 0;
			while (startInd < arr.length && pieces[i][0] != arr[startInd])
				startInd++;
			if (startInd >= arr.length)
				return false;
			for (int j = startInd; j < startInd + pieces[i].length; j++)
				if (j >= arr.length || arr[j] != pieces[i][j - startInd])
					return false;
		}
		return true;
	}
}