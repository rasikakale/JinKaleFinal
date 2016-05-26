
public class Gameboard {

	private int[][] board;
	public final int BOMB = -1;
	private int row;
	private int column;

	public int[][] show;

	public Gameboard(int NumOfRows, int NumberOfColumns) {
		row = NumOfRows;
		column = NumberOfColumns;
		board = new int[row][column];
		show = new int[row][column];
		setBomb();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i][j] != BOMB)
					board[i][j] = getAdjBombs(i, j);
			}
		}
	}

	public void isShowing(int r, int c) {
		isClicked(r, c);
		if (board[r][c] == 0) {
			isClicked(r + 1, c);
			isClicked(r - 1, c);
			isClicked(r - 1, c - 1);
			isClicked(r + 1, c - 1);
			isClicked(r + 1, c + 1);
			isClicked(r - 1, c + 1);
			isClicked(r, c + 1);
			isClicked(r, c - 1);
		}
		if (board[r][c] == BOMB) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					show[i][j] = 1;

				}
			}

		}

	}

	private void isClicked(int r, int c) {

		if (InBoard(r, c)) {
			if (board[r][c] >= 1 && board[r][c] <= 8) {
				show[r][c] = 1;
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

		int numOfBombs = (int) (0.1 * row * column);
		for (int i = 0; i < numOfBombs; i++) {
			int randomRow = getRandomRow();
			int randomCol = getRandomCol();
			board[randomRow][randomCol] = BOMB;
		}

	}

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

	public boolean InBoard(int r, int c) {
		return ((r >= 0 && r < row) && (c >= 0 && c < column));
	}

	public boolean won() {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != BOMB && getAdjBombs(r, c) != 0) {
					return false;

				}
			}
		}
		return true;
	}

	public boolean lose() {
		int sum = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != BOMB) {
					sum++;
				}

			}
		}
		if (sum == (int) (0.1 * row * column)) return true;
		return false;
	}
}
