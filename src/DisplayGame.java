import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;

public class DisplayGame extends PApplet {
	

 private int[][] board = new int[20][20];
 private int[][] bombs = new int[20][20];
 boolean HasBomb;
 int xlength = 20;
 int ylength = 20;
 long t0, t1;
 double dt;
 private Map<Object, Integer> colors;
private Map<Object, PImage> images;

 
 private boolean[][] show = new boolean[20][20];
 Gameboard gameBoard = new Gameboard(20,20, show);

 public void setUp() {
  size(100, 100);
  
  t0 = new Date().getTime();

  DisplayGame.setImage(1, );
  DisplayGame.setImage(2, );
  DisplayGame.setImage(3, );
  DisplayGame.setImage(4, );
  DisplayGame.setImage(5, );
  DisplayGame.setImage(6, );
  DisplayGame.setImage(7, );
  DisplayGame.setImage(8, );
  DisplayGame.setImage(-1, "D:/JinKaleFinal\Bomb.png");
  DisplayGame.setImage(-2, "D:/3079-256x256x32.png");
 }
 
 public void setColor(Object pieceType, Integer color) {
		colors.put(pieceType, color);
 }
 
 private Integer getColor(Object pieceType) {
		Integer col = colors.get(pieceType);
		if (col == null) { // no color defined for this class
			return UNKNOWN_COLOR;
		} else {
			return col;
		}
	}

	public PImage getImage(Object pieceType) {
		PImage img = images.get(pieceType);
		return img;
	}
 
 public void setImage(Object pieceType, String filename) {
		PImage img = p.loadImage(filename);
		setImage(pieceType, img);
	}
 
 public void setImage(Object pieceType, PImage img) {
		images.put(pieceType, img);
	}
 
 public double startTimer() {
t1 = new Date().getTime();

dt = t1 - t0;

return dt / 1000; // divide by 1000 to get seconds instead of milliseconds 

}

 public void mouseReleased() {
  background(255);
  Position clicked = findBoardPosition(this.mouseX, this.mouseY);
  //findBomb
  OpenTiles(clicked.getX(), clicked.getY());
  
 }

 public void draw() {
  drawGrid(board, xlength, ylength);
//  gameBoard.getAdjBombs(20, 20);
  
  textFont("TIMER: " +startTimer());
 }
 

 public void drawGrid(int[][] grid, int l, int h) {
  fill(110, 255, 110);
  for (int il = 0; il < grid.length; il++) {
   for (int ih = 0; ih < grid[0].length; ih++) {
    rect(il * grid.length, ih * grid[0].length, l, h);
   }
  }
 }
 
 public void drawRect(int x, int y, int l, int h, int red, int gr, int bl){
  fill(red, gr, bl);
  stroke(20);
    
  rect(x, y, l, h);
 }
 
 public void OpenTiles(int r, int c) {

	 /*
  if (r < 0 || c < 0 || r >= bombs.length || c >= bombs[0].length)
   return;

  if (bombs[r][c] != 0){
   drawRect(r, c, xlength, ylength, 255, 0, 0);
   return;
  }
  
  if (board[r][c] == 0){
   drawRect(r, c, 21, 21, 0, 0, 255);
   return;
  }
  */
gameBoard.isShowing(r, c);
for (int i = 0; i < show.length; i++) {
	for (int j = 0; j < show[0].length; j++) {
		if (show[i][j] == true) {
			drawRect(i,j,xlength, ylength, 255,0,0);
		
	
}
  
//  drawRect(r+1, c, xlength, ylength, 255, 0, 0);
//  drawRect(r-1, c, xlength, ylength, 255, 0, 0);
//  drawRect(r-1, c-1, xlength, ylength, 255, 0, 0);
//  drawRect(r+1, c-1, xlength, ylength, 255, 0, 0);
//  drawRect(r+1, c+1, xlength, ylength, 255, 0, 0);
//  drawRect(r, c+1, xlength, ylength, 255, 0, 0);
//  drawRect(r, c-1, xlength, ylength, 255, 0, 0);
	}
}
}
/*
  OpenTiles(r + 1, c);
  OpenTiles(r - 1, c);
  OpenTiles(r - 1, c - 1);
  OpenTiles(r + 1, c - 1);
  OpenTiles(r + 1, c + 1);
  OpenTiles(r - 1, c + 1);
  OpenTiles(r, c + 1);
  OpenTiles(r, c - 1);
*/
 
 

 

 public Position findBoardPosition(int mX, int mY) { //finds position where mouse clicked
  int box_x = mX / xlength;
  int box_y = mY / ylength;
  return new Position(box_x, box_y);

 }

 //public void findBomb(int x, int y) { // stores all locations around mouse clicked in array, and then compares all positions to the array of bombs
 // ArrayList<Integer> AdjLocs = new ArrayList<Integer>(); // instead of while loop, I have to use for loop
//how to open a different color of squares with numbers on edges without opening the whole entire grid??
  
/*  while (findBoardPosition(mouseX, mouseY) != bombs[x][y]) {
   AdjLocs.add(x + 1, y);
   AdjLocs.add(x - 1, y);
   AdjLocs.add(x - 1, y - 1);
   AdjLocs.add(x + 1, y - 1);
   AdjLocs.add(x + 1, y + 1);
   AdjLocs.add(x - 1, y + 1);
   AdjLocs.add(x, y + 1);
   AdjLocs.add(x, y - 1);

  }
*/
//  if (findBoardPosition(mouseX, mouseY) == bombs[x][y]) {
//   HasBomb = true;
  
//  }

}


 
 



