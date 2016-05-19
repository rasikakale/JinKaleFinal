import processing.core.PApplet;

public class DisplayGame extends PApplet {

	private int[][] board;
	private int[][] bombs;
	boolean HasBomb;

	public void setUp() {
		size(100, 100);
	}

	public void mouseReleased() {
		background(255);
		OpenTiles(0, 0);
	}

	public void draw() {
		
		drawGrid(bombs, 300, 300);
	}
	
	public void drawGrid(int[][] grid, int w, int h) {
		float box_width = w/grid[0].length;
		float box_height = h/grid.length;
		
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				float x = box_height * h;
				float y = box_width * w;
				
				rect(x, y, box_width, box_height);
				int value = grid[r][c];
				if (value > 0) {
					text(value, x + box_width/2, y + box_height/2);
				}
			}
		}
	}

	public void OpenTiles(int r, int c) {

		if (r < 0 || c < 0 || r >= bombs.length || c >= bombs[0].length)
			return;

		if (bombs[r][c] != 0)
			return;
		if (board[r][c] == 0)
			return;

		OpenTiles(r + 1, c);
		OpenTiles(r - 1, c);
		OpenTiles(r - 1, c - 1);
		OpenTiles(r + 1, c - 1);
		OpenTiles(r + 1, c + 1);
		OpenTiles(r - 1, c + 1);
		OpenTiles(r, c + 1);
		OpenTiles(r, c - 1);

	}

	public void ExplodeBombs(int r, int c) {
		for (int i = 0; i < bombs.length; i++) {
			for (int j = 0; j < bombs[0].length; j++) {
				OpenTiles(r, c);
				if(!HasBomb) {
					
				}

			}
		}
	}

	public void text(int value, float x, float y) {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if (board[r][c] > 0) {
					System.out.print("1");
				}
				
			}
		}
	}
}
