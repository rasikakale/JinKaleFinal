import processing.core.PApplet;

public class DisplayGame extends PApplet {

 private int[][] board;
 private int[][] bombs;

 public void setUp() {
  size(100, 100);
 }

 public void mouseReleased() {
  background(255);
  OpenTiles(0, 0);
 }

 public void draw() {
  for (int r = 0; r < board.length; r++) {
   for (int c = 0; c < board[0].length; c++) {
    rect(4, 1, 3, 2);
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
  for(int i = 0; i < board.length; i++) {
   for(int j = 0; j < board[0].length; j++) {
    
   }
  }
 }

}
