package practice.problems;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Map<Integer, Boolean> digitFound = new HashMap<>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '.')
					continue;
				int nowDigit = board[i][j] - '0';
				if (digitFound.containsKey(nowDigit))
					return false;
				digitFound.put(nowDigit, true);
			}
		}
		for (int j = 0; j < board[0].length; j++) {
			Map<Integer, Boolean> digitFound = new HashMap<>();
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] == '.')
					continue;
				int nowDigit = board[i][j] - '0';
				if (digitFound.containsKey(nowDigit))
					return false;
				digitFound.put(nowDigit, true);
			}
		}
		for (int i = 0; i < board.length; i += 3)
			for (int j = 0; j < board[i].length; j += 3) {
				Map<Integer, Boolean> digitFound = new HashMap<>();
				for (int x = i; x < i + 3; x++)
					for (int y = j; y < j + 3; y++) {
						if (board[x][y] == '.')
							continue;
						int nowDigit = board[x][y] - '0';
						if (digitFound.containsKey(nowDigit))
							return false;
						digitFound.put(nowDigit, true);
					}
			}
		return true;
	}
}