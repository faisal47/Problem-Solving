package practice.problems;

class Solution {

	public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
	}

	private boolean solveSudoku(char[][] board, int i, int j) {
		if (i == 9)
			return true;
		if (board[i][j] != '.') {
			int x = i;
			int y = j + 1;
			if (y >= 9) {
				x++;
				y = 0;
			}
			return solveSudoku(board, x, y);
		}
		for (char ch = '1'; ch <= '9'; ch++) {
			if (isValid(board, i, j, ch)) {
				board[i][j] = ch;
				int x = i;
				int y = j + 1;
				if (y >= 9) {
					x++;
					y = 0;
				}
				if (solveSudoku(board, x, y))
					return true;
				board[i][j] = '.';
			}
		}
		return false;
	}

	private boolean isValid(char[][] board, int i, int j, char ch) {
		for (int x = 0; x < board[i].length; x++)
			if (board[i][x] == ch)
				return false;
		for (int x = 0; x < board.length; x++)
			if (board[x][j] == ch)
				return false;
		for (int x = (i / 3) * 3; x < (i / 3 + 1) * 3; x++)
			for (int y = (j / 3) * 3; y < (j / 3 + 1) * 3; y++)
				if (board[x][y] == ch)
					return false;
		return true;
	}
}