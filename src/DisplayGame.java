import processing.core.PApplet;

public class DisplayGame extends PApplet  {
	
	private int[][] board;
	private int[][] bombs;
	
	
	public void setUp() {
		size(100, 100);
	}
	
	
	public void mouseReleased() {
		background(255);
		OpenTiles()
	}
	
	public void draw() {
		rect(4,1,3,2);
	}

	public void OpenTiles(int r, int c) {
		
		if (r < 0 || c < 0 || r >= bombs.length || c >= bombs[0].length) 
		return;
	
		if(bombs[r][c] != 0) return;
		if(board[r][c] == 0) return;
		
	
	OpenTiles(r + 1, c);
	OpenTiles(r - 1, c);
	OpenTiles(r, c + 1);
	OpenTiles(r, c - 1);

	}
	

}
