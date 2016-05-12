
public class Gameboard {

	static int[][] board;
	final static int BOMB = 4;
	static int row;
	static int column;
	static boolean[][] med;

	// interface location? inheritance?

	public Gameboard(int r, int c) {
		row = r;
		column = c;
		board = new int[row][column];
		int numOfBombs = (int)(0.2*row*column);
		for (int i = 0; i < numOfBombs; i++) {
			int randomRow = getRandomRow();
			int randomCol = getRandomCol();
			board[randomRow][randomCol] = BOMB;
		}
	}
	
	public int getRandomRow() {
		int r = (int)(Math.random()*row);
		return r;
	}
	
	public int getRandomCol() {
		int c = (int)(Math.random()*column);
		return c;
	}

	
	public static boolean HasBomb() {
		
		for (int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {
				if (board[r + 1][c] || board[r][c] == board[] ]) {
					
				}
			}
		}
		
		
		return false; 
	}
		
		
		
		// -1 is has bomb, 1 is no bomb, 0 is space not opened
		// checks whether there is bomb or not in a location on gamboard
		// should check adjacent location from edge to see whether there is bomb
		// or not
	

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}
	
	public void ShowEmptySquares(int r, int c) { // shows all empty squares without numbers when clicking a box
		if (r < 0 || r > row || c < 0 || c > column) {
			return;
		}
		
		ShowEmptySquares(r - 1, c - 1);
		ShowEmptySquares(r - 1, c);
		ShowEmptySquares(r - 1, c + 1);
		ShowEmptySquares(r - 1, c);
		
		ShowEmptySquares
		
	}
	
	public void setFlags() { //shows flags when user right-clicks on square
		
	}
	
	public void setRandomMines() {
		
	}
	

}
