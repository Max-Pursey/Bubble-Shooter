package edu.sjsu.cs151.bubbleshooter.model;

import java.awt.Color;
/**
 * class that represents one single bubble
 * @author maxpu
 *
 */
public class Bubble 
{	
	public Bubble 	left;
	public Bubble 	right;
	public Bubble 	topLeft;
	public Bubble 	topRight;
	public Bubble 	bottomLeft;
	public Bubble 	bottomRight;
	public Color 	color;
	public String 	colorString;
	public boolean 	marked;
	public boolean 	connected;
	public double 	x;
	public double 	y;
	public double 	dx;
	public double 	dy;
	
	/**
	 * creates one single bubble object with any number of neighbors
	 * @param thisLeft
	 * @param thisRight
	 * @param thisTopLeft
	 * @param thisTopRight
	 * @param thisBottomLeft
	 * @param thisBottomRight
	 */
	public Bubble(Bubble thisLeft, Bubble thisRight, Bubble thisTopLeft, Bubble thisTopRight, Bubble thisBottomLeft, 
	Bubble thisBottomRight)
	{
		left = thisLeft;
		if (thisLeft != null) {
			thisLeft.right = this;
		}
		right = thisRight;
		if (thisRight != null) {
			thisRight.left = this;
		}
		topLeft = thisTopLeft;
		if (thisTopLeft != null) {
			thisTopLeft.bottomRight = this;
		}
		topRight = thisTopRight;
		if (thisTopRight != null) {
			thisTopRight.bottomLeft = this;
		}
		bottomLeft = thisBottomLeft;
		if (thisBottomLeft != null) {
			thisBottomLeft.topRight = this;
		}
		bottomRight = thisBottomRight;
		if (thisBottomRight != null) {
			thisBottomRight.topLeft = this;
		}
		color = this.randomColor();
	}
	
	/**
	 * creates a bubble from the supplied bubble
	 * @param that
	 */
	public Bubble(Bubble that) {
		this.left = that.left;
		this.right = that.right;
		this.topLeft = that.topLeft;
		this.topRight = that.topRight;
		this.bottomLeft = that.bottomLeft;
		this.bottomRight = that.bottomRight;
		this.color = that.color;
		this.colorString = that.colorString;
		this.marked = that.marked;
		this.connected = that.connected;
		this.x = that.x;
		this.y = that.y;
		this.dx = that.dx;
		this.dy = that.dy;
	} 
	
	/**
	 * sets a random color for a bubble
	 * @return color
	 */
	public Color randomColor() {
		double randNumber = Math.random() * 6;
		
		if		(randNumber > 5) 	{ colorString = " Red  "; return Color.RED; 	}
		else if	(randNumber > 4) 	{ colorString = "Yellow"; return Color.YELLOW; 	}
		else if	(randNumber > 3)	{ colorString = "Green "; return Color.GREEN; 	}
		else if	(randNumber > 2)	{ colorString = " Cyan "; return Color.CYAN; 	}
		else if	(randNumber > 1)	{ colorString = " Blue "; return Color.BLUE; 	}
		else						{ colorString = " Pink "; return Color.MAGENTA; }
	}	
	
	/**
	 * flips the marked boolean variable
	 * @param marked
	 */
	public void setMarked(boolean marked) { this.marked = marked; }
	
	/**
	 * flips the connected boolean variable
	 * @param connected
	 */
	public void setConnected(boolean connected) { this.connected = connected; }
	
	/**
	 * returns a string of the color
	 */
	public String toString() { return colorString; }

	// takes in board location x and y
	/**
	 * connects the bubble at x and y to its neighbors
	 * @param x
	 * @param y
	 */
	public void connectNeighbors(int x, int y) {
		// left
		if(x-1 >= 0 && Board.board[x-1][y] != null) 
			left = Board.board[x-1][y];
		
		// right
		if(x+1 <= 9 && Board.board[x+1][y] != null)
			right = Board.board[x+1][y];
		
		// topLeft
		if(y%2 == 0) {
			if(x-1 >= 0 && y-1 >= 0 && Board.board[x-1][y-1] != null)
				topLeft = Board.board[x-1][y-1];
		}
		else if(y-1 >= 0 && Board.board[x][y-1] != null)
				topLeft = Board.board[x][y-1];

		// topRight
		if(y%2 == 0) {
			if(y-1 >= 0 && Board.board[x][y-1] != null)
				topRight = Board.board[x][y-1];
		}
		else if(x+1 <= 9 && y-1 >= 0 && Board.board[x+1][y-1] != null)
				topRight = Board.board[x+1][y-1];
		// bottomLeft
		if(y%2 == 0) {
			if(x-1 >= 0 && y+1 <= 9 && Board.board[x-1][y+1] != null)
				bottomLeft = Board.board[x-1][y+1];
		}
		else if(y+1 <= 9 && Board.board[x][y+1] != null)
				bottomLeft = Board.board[x][y+1];
		
			
		// bottomRight
		if(y%2 == 0) {
			if(y+1 <= 9 && Board.board[x][y+1] != null)
				bottomRight = Board.board[x][y+1];
		}
		else if(x+1 <= 9 && y+1 <= 9 && Board.board[x+1][y+1] != null)
				bottomRight = Board.board[x+1][y+1];
		
	}
}
