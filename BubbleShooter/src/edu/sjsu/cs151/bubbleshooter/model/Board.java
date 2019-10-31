package edu.sjsu.cs151.bubbleshooter.model;

import edu.sjsu.cs151.bubbleshooter.controller.Controller;

/**
 * A class that displays board, bubbles, and bubble shooter
 * Singleton pattern
 */
public final class Board {

	private static final Board INSTANCE = new Board();
	public Bubble[][] board;
	
	/**
	 * Constructs a Board object that holds the grid of bubbles.
	 */
	private Board() {
		board = new Bubble[10][10];
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
		for(int y = 1; y < 4; y++)
		{
			yCoordinate = yCoordinate + 0.8660254038;
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
	
	public static Board getInstance() {
		return INSTANCE;
	}
	
	public Bubble[][] getBoardBubbles() {
		return board;
	}
	
	
	public void removeBubble(int x, int y) {
		board[x][y] = null;
	}
}
