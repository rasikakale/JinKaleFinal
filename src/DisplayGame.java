import java.util.ArrayList;

import processing.core.PApplet;

public class DisplayGame extends PApplet {

 private int[][] board = new int[20][20];
 private int[][] bombs = new int[20][20];
 boolean HasBomb;
 int xlength = 20;
 int ylength = 20;

 public void setUp() {
  size(100, 100);
 }

 public void mouseReleased() {
  background(255);
  Position clicked = findBoardPosition(this.mouseX, this.mouseY);
  //findBomb
  OpenTiles(clicked.getX(), clicked.getY());
 }

 public void draw() {

  drawGrid(board, xlength, ylength);
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
  
  drawRect(r+1, c, xlength, ylength, 255, 0, 0);
  drawRect(r-1, c, xlength, ylength, 255, 0, 0);
  drawRect(r-1, c-1, xlength, ylength, 255, 0, 0);
  drawRect(r+1, c-1, xlength, ylength, 255, 0, 0);
  drawRect(r+1, c+1, xlength, ylength, 255, 0, 0);
  drawRect(r, c+1, xlength, ylength, 255, 0, 0);
  drawRect(r, c-1, xlength, ylength, 255, 0, 0);
  
  
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
 }
 

 

 public Position findBoardPosition(int mX, int mY) { //finds position where mouse clicked
  int box_x = mX / xlength;
  int box_y = mY / ylength;
  return new Position(box_x, box_y);

 }

 public void findBomb(int x, int y) { // stores all locations around mouse clicked in array, and then compares all positions to the array of bombs
  ArrayList<Integer> AdjLocs = new ArrayList<Integer>(); // instead of while loop, I have to use for loop

  
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
 
}
