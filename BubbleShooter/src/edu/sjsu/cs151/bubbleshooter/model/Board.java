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
		board = new Bubble[5][5]; 
		for(int x = 0; x < 5; x++)
		{
			Bubble bubble = new Bubble(board[x-1][1], null, null, null, null, null);	
			board[x][1] = bubble;
		}
		for(int y = 1; y < 3; y++)
		{
			for(int x = 0; x < 5; x++)
			{
				if(y % 2 == 0)
				{
					Bubble bubble = new Bubble(board[x-1][y], null, null, board[x+1][y-1], null, null);	
					board[x][y] = bubble;
				}
				else
				{
					Bubble bubble = new Bubble(board[x-1][y], null, board[x][y-1], board[x+1][y-1], null, null);	
					board[x][y] = bubble;
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
