
public class Gameboard {

	private int[][] board;
	final static int BOMB = -1;
	final static int FLAG = -2;
	private int row;
	private int column;
	private boolean[][] med; // checks to see whether numbers will show or not
	// on grid
	// private boolean[][] flags;
	// private boolean[][] bombs;
	private boolean[][] show;

	public Gameboard(int NumOfRows, int NumberOfColumns, boolean[][] s) {
		row = NumOfRows;
		column = NumberOfColumns;
		board = new int[row][column];
		show = new boolean[row][column];
		setBomb();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] != BOMB)
					board[i][j] = getAdjBombs(i, j);
			}
		}
	}

	public void isShowing(int r, int c) {
		if (InBoard(r, c)) {
			if (board[r][c] >= 1 && board[r][c] <= 8) {
				show[r][c] = true;
			}
			if (board[r][c] == 0) {
				isShowing(r + 1, c);
				isShowing(r - 1, c);
				isShowing(r - 1, c - 1);
				isShowing(r + 1, c - 1);
				isShowing(r + 1, c + 1);
				isShowing(r - 1, c + 1);
				isShowing(r, c + 1);
				isShowing(r, c - 1);
			}
			if (board[r][c] == BOMB) {
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						show[i][j] = true;
					}
				}
			}
		}
	}

	public int getRandomRow() {
		int r = (int) (Math.random() * row);
		return r;
	}

	public int getRandomCol() {
		int c = (int) (Math.random() * column);
		return c;
	}

	public void setBomb() {

		int numOfBombs = (int) (0.2 * row * column);
		for (int i = 0; i < numOfBombs; i++) {
			int randomRow = getRandomRow();
			int randomCol = getRandomCol();
			board[randomRow][randomCol] = BOMB;
		}

	}
	/*
	 * public boolean IsBomb(int r, int c) { return bombs[r][c]; }
	 * 
	 * public boolean isFlag(int r, int c) { return flags[r][c]; }
	 */

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public int getAdjBombs(int r, int c) {
		int mines = 0;
		for (int i = r - 1; i <= r + 1; i++) {
			for (int j = c - 1; j <= c + 1; j++) {
				if (InBoard(i, j) && board[i][j] == BOMB) {
					mines++;
				}
			}
		}
		return mines;
	}

	public void CalcMines() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != BOMB) {
					board[i][j] = getAdjBombs(i, j);
				}
			}
		}
	}


	public void resetGame() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				med[r][c] = false;
			}

		}

	}

	public boolean InBoard(int r, int c) {
		return ((r >= 0 && r < row) && (c >= 0 && c < column));
	}

}
