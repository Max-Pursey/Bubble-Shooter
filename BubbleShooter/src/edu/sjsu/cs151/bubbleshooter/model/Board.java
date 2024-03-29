package edu.sjsu.cs151.bubbleshooter.model;

import java.util.ArrayList;
import edu.sjsu.cs151.bubbleshooter.controller.Visitor;

/**
 * A class that displays board, bubbles, and bubble shooter
 * Singleton pattern
 */
public final class Board {

	private static final Board INSTANCE = new Board();
	public static int addRowCount;
	public static Bubble[][] board;
	public static ArrayList<Bubble> ammo;
	public static int numAmmo;
	
	
	/**
	 * Constructs a Board object that holds the grid of bubbles.
	 */
	private Board() {
		board = new Bubble[10][11];
		ammo = new ArrayList<Bubble>();
		numAmmo = 5;
		addRowCount = 0;
		fillAmmo();
		double xCoordinate = 0;
		double yCoordinate = 0;
		for(int x = 0; x < 10; x++)
		{
			if(x == 0)
			{
				Bubble bubble = new Bubble(null, null, null, null, null, null);	
				board[x][0] = bubble;
				xCoordinate = 0;
				bubble.x = xCoordinate;
				bubble.y = yCoordinate;
			}
			else
			{
				Bubble bubble = new Bubble(board[x-1][0], null, null, null, null, null);	
				board[x][0] = bubble;
				xCoordinate = xCoordinate + 1;
				bubble.x = xCoordinate;
				bubble.y = yCoordinate;
			}
		}
		for(int y = 1; y < 5; y++)
		{
			yCoordinate = yCoordinate + 0.8660254038;  //this is the vertical distance between hexes.
			for(int x = 0; x < 10; x++)
			{
				if(y % 2 == 0)
				{
					if(x == 0)
					{
						Bubble bubble = new Bubble(null, null, null, board[x][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = 0;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;    // this is setting the y coordinate to the actual value which is slightly less than 1.
	 				}
					else
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x-1][y-1], board[x][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
				}
				else
				{
					if(x == 9)
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x][y-1], null, null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;                 // This offsets the X coordinate to make it follow a hex grid.
						bubble.y = yCoordinate;
					}
					else if(x == 0)
					{
						Bubble bubble = new Bubble(null, null, board[x][y-1], board[x+1][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = 0.5;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
					else
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x][y-1], board[x+1][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
				}
			}
		}
	}
	
	/**
	 * remakes the board and ammo.
	 */
	public void repopulateBoard()
	{
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length-1; x++)
			{
				board[x][y] = null;
			}
		}
		ammo.clear();
		numAmmo = 5;
		addRowCount = 0;
		fillAmmo();
		double xCoordinate = 0;
		double yCoordinate = 0;
		for(int x = 0; x < 10; x++)
		{
			if(x == 0)
			{
				Bubble bubble = new Bubble(null, null, null, null, null, null);	
				board[x][0] = bubble;
				xCoordinate = 0;
				bubble.x = xCoordinate;
				bubble.y = yCoordinate;
			}
			else
			{
				Bubble bubble = new Bubble(board[x-1][0], null, null, null, null, null);	
				board[x][0] = bubble;
				xCoordinate = xCoordinate + 1;
				bubble.x = xCoordinate;
				bubble.y = yCoordinate;
			}
		}
		for(int y = 1; y < 5; y++)
		{
			yCoordinate = yCoordinate + 0.8660254038;  //this is the vertical distance between hexes.
			for(int x = 0; x < 10; x++)
			{
				if(y % 2 == 0)
				{
					if(x == 0)
					{
						Bubble bubble = new Bubble(null, null, null, board[x][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = 0;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;    // this is setting the y coordinate to the actual value which is slightly less than 1.
	 				}
					else
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x-1][y-1], board[x][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
				}
				else
				{
					if(x == 9)
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x][y-1], null, null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;                 // This offsets the X coordinate to make it follow a hex grid.
						bubble.y = yCoordinate;
					}
					else if(x == 0)
					{
						Bubble bubble = new Bubble(null, null, board[x][y-1], board[x+1][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = 0.5;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
					else
					{
						Bubble bubble = new Bubble(board[x-1][y], null, board[x][y-1], board[x+1][y-1], null, null);	
						board[x][y] = bubble;
						xCoordinate = xCoordinate + 1;
						bubble.x = xCoordinate;
						bubble.y = yCoordinate;
					}
				}
			}
		}
	}
	
	/**
	 * visits ever possible bubble position on the board
	 * @param visitor
	 */
	public static void visit(Visitor visitor)
	{
		for(int x = 0; x < board.length; x++)
		{
			for(int y = 0; y < board[x].length; y++)
			{
				visitor.visitBubble(board[x][y]);	
			}
		}
	}
	
	/**
	 * settles a bubble in its new position on the board after hitting another bubble
	 * @param waywardBubble
	 */
	public static void settleBubble(Bubble waywardBubble)
	{
		int currentX;
		int currentY = (int) Math.round(waywardBubble.y/0.8660254038);
		if(currentY % 2 != 0)
		{
			currentX = (int) Math.round(waywardBubble.x-0.5);
			waywardBubble.y = currentY*0.8660254038;
			waywardBubble.x = currentX+0.5;
		}
		else
		{
			currentX = (int) Math.round(waywardBubble.x);
			waywardBubble.y = currentY*0.8660254038;
			waywardBubble.x = currentX;
		}
		Board.setBubble(currentX, currentY, waywardBubble);
	}
	/**
	 * part of settleBubble, this actually puts the bubble in its place on the board
	 * @param x
	 * @param y
	 * @param bubble
	 */
	public static void setBubble(int x, int y, Bubble bubble)
	{
		if(x == -1)
			board[x+1][y] = bubble;
		else if (x == 10)
			board[x-1][y] = bubble;
		else
			board[x][y] = bubble;
		if(x-1 == -1 || x-1 == -2)
			bubble.left = null;
		else if(board[x-1][y] != null)
		{
			bubble.left = board[x-1][y];
			board[x-1][y].right = bubble;
		}
		if(x+1 == 10 || x+1 == 11)
			bubble.right = null;
		else if(board[x+1][y] != null)
		{
			bubble.right = board[x+1][y];
			board[x+1][y].left = bubble;
		}
		if(y % 2 == 0)
		{
			if(x-1 == -1)
				bubble.topLeft = null;
			else if(board[x-1][y-1] != null)
			{
				bubble.topLeft = board[x-1][y-1];
				board[x-1][y-1].bottomRight = bubble;
			}
			if(x == 10)
			{
				bubble.topRight = board[x-1][y-1];
				board[x-1][y-1].bottomLeft = bubble;
			}
			else if(board[x][y-1] != null)
			{
				bubble.topRight = board[x][y-1];
				board[x][y-1].bottomLeft = bubble;
			}
		}
		else
		{
			if(board[x][y-1] != null)
			{
				bubble.topLeft = board[x][y-1];
				board[x][y-1].bottomRight = bubble;
			}
			if(x+1 == 10)
				bubble.topRight = null;
			else if(board[x+1][y-1] != null)
			{
				bubble.topRight = board[x+1][y-1];
				board[x+1][y-1].bottomLeft = bubble;
			}
		}
	}
	
	/**
	 * returns the instance of the board.
	 * @return
	 */
	public static Board getInstance() {
		return INSTANCE;
	}
	
	/**
	 * returns a 2d array of bubbles representing the board
	 * @return board
	 */
	public Bubble[][] getBoardBubbles() {
		return board;
	}
	
	/**
	 * removes a bubble from the board array
	 * @param x
	 * @param y
	 */
	public static void removeBubble(int x, int y) {
		board[x][y] = null;
	}
	
	/**
	 * Fills the ammo arraylist with new bubbles.
	 */
	public static void fillAmmo()
	{
		
		if(numAmmo < 1)
			numAmmo = 1;
		for(int i = 0; i < numAmmo; i++)
		{
			ammo.add(new Bubble(null,null,null,null,null,null));
		}
		allignAmmo();
		
	}
	
	/**
	 * Aligns the ammo on the board for view
	 */
	public static void allignAmmo() {
		for(int i = 0; i < ammo.size()-1; i++) {
			ammo.get(i).x = i;
			ammo.get(i).y = 8.660254038;
		}
		Bubble loaded = ammo.get(ammo.size()-1);
		loaded.x = 5;
		loaded.y = 8.660254038;
	}
	
	
}
