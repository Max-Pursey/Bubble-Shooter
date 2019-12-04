package edu.sjsu.cs151.bubbleshooter.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * A class for running the program
 */

public class Model extends JFrame {

	public final static double MAGNITUDE = .1;
	public final static Scanner scan = new Scanner(System.in);
	
	/**
	 * Main method that runs the game
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.print("Enter any key to run: ");
		scan.nextLine();
		run();
	}
	
	/**
	 * The main running part of the program that controls the game
	 * and its user 
	 */
	public static void run() {
		Board board = Board.getInstance();
		System.out.println("\nBoard Created.");
		
		System.out.println("Preparing to fire a bubble...");
		System.out.print("Enter the x vector dimension(-5.0 to 5.0): ");
		double xVec = scan.nextDouble();
		System.out.print("Enter the y vector dimension(0.1 to 5.0): ");
		double yVec = scan.nextDouble();
		
		// bubble created outside the board
		Bubble loaded = new Bubble(null,null,null,null,null,null);
		loaded.x = 4;
		loaded.y = 10;
		loaded.dx = xVec;
		loaded.dy = yVec;
		System.out.println("\nBubble Created.");
		
		System.out.println("Enter any to to fire");
	}
	
	void settleBubble(Bubble waywardBubble)
	{
		int currentX;
		int currentY = (int) Math.round(waywardBubble.y/0.8660254038);
		if(currentY % 2 != 0)
		{
			currentX = (int) Math.round(waywardBubble.x);
		}
		else
		{
			currentX = (int) Math.round(waywardBubble.x-0.5);
		}
		if(currentY % 2 != 0)
		{
			waywardBubble.y = currentY*0.8660254038;
			waywardBubble.x = currentX+0.5;
		}
		else
		{
			waywardBubble.y = currentY*0.8660254038;
		}
		Board.getInstance().setBubble(currentX, currentY, waywardBubble);
	}
	
	/**
	 * adds a row to the game board.
	 */
	public void addRow()
	{
		for(int x = Board.getInstance().board.length-1; x >= 0; x--)
		{
			for(int y = Board.getInstance().board[x].length-1; y >= 1; y--)
			{
				if(Board.getInstance().board[x][y] != null && y+1 != 10)
				{
					if(y%2 == 0)
					{
						if(x == Board.getInstance().board.length-1)
						{
							Board.getInstance().board[x][y].topLeft = Board.getInstance().board[x][y].topRight;
							Board.getInstance().board[x][y].topRight = null;
							Board.getInstance().board[x][y].bottomLeft = Board.getInstance().board[x][y].bottomRight;
							Board.getInstance().board[x][y].bottomRight = null;
						}
						else
						{
							Board.getInstance().board[x][y].topLeft = Board.getInstance().board[x][y].topRight;
							Board.getInstance().board[x][y].topRight = Board.getInstance().board[x+1][y-1];
							Board.getInstance().board[x][y].bottomLeft = Board.getInstance().board[x][y].bottomRight;
							Board.getInstance().board[x][y].bottomRight = Board.getInstance().board[x+1][y+1];
						}
						Board.getInstance().board[x][y+1] = Board.getInstance().board[x][y];
						Board.getInstance().board[x][y].x = Board.getInstance().board[x][y].x + 0.5;
						Board.getInstance().board[x][y].y = Board.getInstance().board[x][y].y + 0.8660254038;
					}
					else
					{
						if(x == 0)
						{
							Board.getInstance().board[x][y].topRight = Board.getInstance().board[x][y].topLeft;
							Board.getInstance().board[x][y].topLeft = null;
							Board.getInstance().board[x][y].bottomRight = Board.getInstance().board[x][y].bottomLeft;
							Board.getInstance().board[x][y].bottomLeft = null;
						}
						else
						{
							Board.getInstance().board[x][y].topRight = Board.getInstance().board[x][y].topLeft;
							Board.getInstance().board[x][y].topLeft = Board.getInstance().board[x-1][y-1];
							Board.getInstance().board[x][y].bottomRight = Board.getInstance().board[x][y].bottomLeft;
							Board.getInstance().board[x][y].bottomLeft = Board.getInstance().board[x-1][y+1];
						}
						Board.getInstance().board[x][y+1] = Board.getInstance().board[x][y];
						Board.getInstance().board[x][y].x = Board.getInstance().board[x][y].x - 0.5;
						Board.getInstance().board[x][y].y = Board.getInstance().board[x][y].y + 0.8660254038;
					}
				}
			}
		}
		for(int x = Board.getInstance().board.length-1; x >= 0; x--)
		{
			if(x == Board.getInstance().board.length-1)
			{
				Board.getInstance().board[x][0].bottomLeft = Board.getInstance().board[x][0].bottomRight;
				Board.getInstance().board[x][0].bottomRight = null;
			}
			else
			{
				Board.getInstance().board[x][0].bottomLeft = Board.getInstance().board[x][0].bottomRight;
				Board.getInstance().board[x][0].bottomRight = Board.getInstance().board[x+1][1];
			}
			Board.getInstance().board[x][0+1] = Board.getInstance().board[x][0];
			Board.getInstance().board[x][0].x = Board.getInstance().board[x][0].x + 0.5;
			Board.getInstance().board[x][0].y = Board.getInstance().board[x][0].y + 0.8660254038;
		}
		for(int x = 0; x < Board.getInstance().board.length-1; x++)
		{
			if(x == 0)
				Board.getInstance().board[x][0] = new Bubble(null, null, null, null, null, Board.getInstance().board[x][1]);
			else
			{
				Board.getInstance().board[x][0] = new Bubble(null, null, null, null, Board.getInstance().board[x-1][1], Board.getInstance().board[x][1]);
				Board.getInstance().board[x][0].x = x;
			}
		}
	}
	
	public static ArrayList<Bubble> checkCombinations(Bubble source) {
		Color c = source.color;
		source.flipMarked();
		ArrayList<Bubble> combination = new ArrayList<>();
		
		if(c == source.left.color && !source.left.marked)
			combination.addAll(checkCombinations(source.left));
		
		if(c == source.right.color && !source.right.marked)
			combination.addAll(checkCombinations(source.right));
		
		if(c == source.topLeft.color && !source.topLeft.marked)
			combination.addAll(checkCombinations(source.topLeft));
	 	
		if(c == source.topRight.color && !source.topRight.marked)
			combination.addAll(checkCombinations(source.topRight));
		
		if(c == source.bottomLeft.color && !source.bottomLeft.marked)
			combination.addAll(checkCombinations(source.bottomLeft));
		
		if(c == source.bottomRight.color && !source.bottomRight.marked)
			combination.addAll(checkCombinations(source.bottomRight));
		
		return combination;
	}
	
	
	
	// if arraylist greater than 3 pop them and add to scoreboard
	// scoreboard needs to be implemented
	// @precondition pop.size() >= 3
	public void pop(ArrayList<Bubble> pop) {
		for(Bubble source: pop) {
			source.left.right 			= null;
			source.right.left 			= null;
			source.topLeft.bottomRight 	= null;
			source.topRight.bottomLeft 	= null;
			source.bottomLeft.topRight 	= null;
			source.bottomRight.topLeft 	= null;
			int x = (int) source.x;
			int y = (int) source.y;
			Board.getInstance().removeBubble(x,y);
		}
		
	}
	
	public void moveBubble(Bubble bubble) {
		// adds the vector to position
		bubble.x = bubble.x + bubble.dx * MAGNITUDE;
		bubble.y = bubble.y + bubble.dy * MAGNITUDE;
	}
}
