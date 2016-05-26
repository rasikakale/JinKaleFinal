import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class DisplayGame extends PApplet {

	private static final Integer UNKNOWN_COLOR = null;
	private int[][] board = new int[20][20];
	private int[][] bombs = new int[20][20];
	private boolean GameState;
	boolean HasBomb;
	int xlength = 20;
	int ylength = 20;
	long t0, t1;
	double dt;
	Position clicked;
	int pieceType;
	PFont f;

	private static HashMap<Integer, PImage> images;
	PImage img0, img1, img2, img3, img4, img5, img6, img7, img8, imgb;

	Gameboard gameBoard = new Gameboard(20, 20);

	public void setup() {
		size(400, 400);
		images = new HashMap<Integer, PImage>();
		f = createFont("Arial", 16, true);

		t0 = new Date().getTime();

		img0 = loadImage("../assets/minesweeper_tiles0.jpg");
		img1 = loadImage("../assets/minesweeper_tiles1.jpg");
		img2 = loadImage("../assets/minesweeper_tiles2.jpg");
		img3 = loadImage("../assets/minesweeper_tiles3.jpg");
		img4 = loadImage("../assets/minesweeper_tiles4.jpg");
		img5 = loadImage("../assets/minesweeper_tiles5.jpg");
		img6 = loadImage("../assets/minesweeper_tiles6.jpg");
		img7 = loadImage("../assets/minesweeper_tiles7.jpg");
		img8 = loadImage("../assets/minesweeper_tiles8.jpg");
		imgb = loadImage("../assets/minesweeper_tilesbomb.jpg");

	}

	// public PImage getImage(int pieceType) {
	// PImage img = images.get(pieceType);
	// return img;
	// }
	//
	// public void setImage(String filename) {
	// PImage img = this.loadImage(filename);
	// setImage(pieceType, img);
	// }
	//
	// public static void setImage(int pieceType, PImage img) {
	// images.put(pieceType, img);
	// }

	public double startTimer() {
		t1 = new Date().getTime();

		dt = t1 - t0;

		return dt / 1000;

	}

	public double stopTimer() {
		return t1;
	}

	public void mouseReleased() {
		background(255);
		this.clicked = findBoardPosition(this.mouseX, this.mouseY);
	}

	public void draw() {
		drawGrid(board, xlength, ylength);
		if (clicked != null) {
			OpenTiles(clicked.getX(), clicked.getY());
		}

		textFont(f, 16);
		fill(0);

		textAlign(DOWN);

		text("TIMER: " + startTimer(), 100, 100);

		// setImage(0, img0);
		// setImage(1, img1);
		// setImage(2, img2);
		// setImage(3, img3);
		// setImage(4, img4);
		// setImage(5, img5);
		// setImage(6, img6);
		// setImage(7, img7);
		// setImage(8, img8);
		// setImage(-1, imgb);

		// image(img0,0,0);

		// gameBoard.getAdjBombs(20, 20);

		// message("TIMER: " + startTimer());

	}

	public void drawGrid(int[][] grid, int l, int h) {
		fill(110, 255, 110);
		for (int il = 0; il < grid.length; il++) {
			for (int ih = 0; ih < grid[0].length; ih++) {
				rect(il * grid.length, ih * grid[0].length, l, h);
			}
		}

	}

	public void OpenTiles(int r, int c) {

		fill(255, 0, 0);
		gameBoard.isShowing(r, c);
		for (int i = 0; i < gameBoard.show.length; i++) {
			for (int j = 0; j < gameBoard.show[0].length; j++) {
				if (gameBoard.show[i][j] == 1) {
					rect(i * 20, j * 20, xlength, ylength);
				}

			}
		}
	}

	public void message(String message) {
		fill(100);
		rect(0, 0, 10, 10);

		fill(255);
		text(message, 10 / 2, 10 / 2);

	}

	public Position findBoardPosition(int mX, int mY) { // finds position where
														// mouse clicked
		int box_x = mX / xlength;
		int box_y = mY / ylength;
		return new Position(box_x, box_y);

	}

	public void WinOrLose() { // method doesn't work for some reason
		if (GameState == gameBoard.won()) {
			message("YAY You Won!!");
		}

		if (GameState == gameBoard.lose()) {
			message("Game Over! You lost!");
		}
	}

}
