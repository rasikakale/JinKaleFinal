
public class Gameboard {

	private int[][] board;
	final static int BOMB = 4;
	private int row = 10;
	private int column = 10;
	private boolean[][] med; // checks to see whether numbers will show or not
								// on grid
	private boolean[][] flags;
	private boolean[][] bombs;

	private int startTime;
	private int endTime;

	public Gameboard(int r, int c) {
		row = r;
		column = c;
		board = new int[row][column];

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

	public boolean IsBomb(int r, int c) {
		return bombs[r][c];
	}

	public boolean isFlag(int r, int c) {
		return flags[r][c];
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public void ShowEmptySquares(int r, int c) { // shows all empty squares
													// without numbers when
													// clicking a box
		if (r < 0 || r > row || c < 0 || c > column) {
			return;
		}

		ShowEmptySquares(r - 1, c - 1);
		ShowEmptySquares(r - 1, c);
		ShowEmptySquares(r - 1, c + 1);
		ShowEmptySquares(r - 1, c);

		// ShowEmptySquares

	}

	public void setFlags() { // shows flags when user right-clicks on square

	}

	public void resetGame() {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				med[r][c] = false;
			}

		}

	}

	public int getAdjacentBombs(int r, int c) {
		int count = 0;
		for (int i = 0; i < bombs.length; i++) {
			for (int j = 0; j < bombs[0].length; j++) {
				if (bombs[i][j] == bombs[r - 1][c - 1] || bombs[i][j] == bombs[r][c - 1]
						|| bombs[i][j] == bombs[r + 1][c - 1] || bombs[i][j] == bombs[r + 1][c]
						|| bombs[i][j] == bombs[r + 1][c + 1] || bombs[r][c + 1] || bombs[i][j] == bombs[r - 1][c + 1]
						|| bombs[i][j] == bombs[r - 1][c]) {
					
					count++;
				}
			}
		}
		return count;
	}

}
