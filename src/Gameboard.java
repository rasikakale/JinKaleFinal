
public class Gameboard {

	int[][] board;
	final static int BOMB = 4;
	int row;
	int column;

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
		return false; // -1 is has bomb, 1 is no bomb, 0 is space not opened
		// checks whether there is bomb or not in a location on gamboard
		// should check adjacent location from edge to see whether there is bomb
		// or not
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

}
