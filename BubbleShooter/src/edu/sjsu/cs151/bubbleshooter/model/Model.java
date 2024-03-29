package edu.sjsu.cs151.bubbleshooter.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

import edu.sjsu.cs151.bubbleshooter.controller.*;

/**
 * A class for running the model of the game
 */

@SuppressWarnings("serial")
public class Model extends JFrame {

	public final static double MAGNITUDE = .1;
	public final static Scanner scan = new Scanner(System.in);
	public static int score;
	
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
	
	/**
	 * adds a row to the game board.
	 */
	public static void addRow()
	{
		
		// move each bubble starting from the bottom right, down and over
		
		for(int x = Board.board.length - 1 ; x >= 0; x--) {
			for(int y = Board.board.length - 1; y >= 0; y--) {
				if(y+1 < 11 &&  Board.board[x][y] != null) {
					Board.board[x][y].left = null;
					Board.board[x][y].right = null;
					Board.board[x][y].topLeft = null;
					Board.board[x][y].topRight = null;
					Board.board[x][y].bottomLeft = null;
					Board.board[x][y].bottomRight = null;
					if(y%2 == 0) {
						Board.board[x][y].x = Board.board[x][y].x + 0.5;
						Board.board[x][y].y = Board.board[x][y].y + 0.8660254038;
						Board.board[x][y+1] = new Bubble(Board.board[x][y]);
						Board.removeBubble(x,y);
					}
					else {
						Board.board[x][y].x = Board.board[x][y].x - 0.5;
						Board.board[x][y].y = Board.board[x][y].y + 0.8660254038;
						Board.board[x][y+1] = new Bubble(Board.board[x][y]);
						Board.removeBubble(x,y);
					}
				}
				else
					try {
						Controller.messageQueue.put(new GameOverMessage());
					}
					catch(InterruptedException exception) {
						exception.printStackTrace();
					}
			}	
		}
		
		// add new bubbles in first row
		
		for(int x = 0; x < Board.board.length; x++)
		{
				Board.board[x][0] = new Bubble(null, null, null, null, null, null);
				Board.board[x][0].x = x;
				Board.board[x][0].y = 0;
		}
		
		// connect all bubbles to their neighbors
		
		for(int x = 0; x < Board.board.length; x++) {
			for(int y = 0; y < Board.board[x].length; y++) {
				if(Board.board[x][y] != null) {
					Board.board[x][y].connectNeighbors(x, y);
				}
			}
		}
	}
	
	/**
	 * checks for other bubbles of the same color next to the source
	 * @param source
	 */
	public static void checkCombinations(Bubble source) {
		Color c = source.color;
		source.setMarked(true);
		
		if(source.left != null && c == source.left.color)
			checkCombinations(source.left);
		
		if(source.right != null && c == source.right.color && !source.right.marked)
			checkCombinations(source.right);
		
		if(source.topLeft != null && c == source.topLeft.color && !source.topLeft.marked) {
			checkCombinations(source.topLeft);
		}
	 	
		if(source.topRight != null && c == source.topRight.color && !source.topRight.marked) {
			checkCombinations(source.topRight);
		}
		
		if(source.bottomLeft != null && c == source.bottomLeft.color && !source.bottomLeft.marked)
			checkCombinations(source.bottomLeft);
		
		if(source.bottomRight != null && c == source.bottomRight.color && !source.bottomRight.marked)
			checkCombinations(source.bottomRight);
	
	}
	
	
	
	// if arraylist greater than 3 pop them and add to scoreboard
	// scoreboard needs to be implemented
	// @precondition pop.size() >= 3
	/**
	 * pops a bubble, deleting it from the board
	 * @param pop
	 */
	public static void pop(ArrayList<Bubble> pop) {
		score += pop.size()*100;
		for(Bubble source: pop) {
			
			if(source.left != null)
				source.left.right 			= null;
			if(source.right != null)
				source.right.left 			= null;
			if(source.topLeft != null)
				source.topLeft.bottomRight 	= null;
			if(source.topRight != null)
				source.topRight.bottomLeft 	= null;
			if(source.bottomLeft != null)
				source.bottomLeft.topRight 	= null;
			if(source.bottomRight != null)
				source.bottomRight.topLeft 	= null;
			int x = (int) source.x;
			int y = (int) (source.y/0.8660254038);
			source.setConnected(true);
			source.setMarked(false);
			Board.removeBubble(x,y);
		}
		
	}
	
	/**
	 * checks if a bubble is connected
	 * @param source
	 */
	public static void checkConnected(Bubble source) {
		source.setConnected(true);
		
		if(source.left != null && !source.left.connected)
			checkConnected(source.left);
		if(source.right != null && !source.right.connected)
			checkConnected(source.right);
		if(source.topLeft != null && !source.topLeft.connected)
			checkConnected(source.topLeft);
		if(source.topRight != null && !source.topRight.connected)
			checkConnected(source.topRight);
		if(source.bottomLeft != null && !source.bottomLeft.connected)
			checkConnected(source.bottomLeft);
		if(source.bottomRight != null && !source.bottomRight.connected)
			checkConnected(source.bottomRight);
		
		
	}
	
	/**
	 * moves a bubble by its direction
	 * @param bubble
	 */
	public void moveBubble(Bubble bubble) {
		// adds the vector to position
		bubble.x = bubble.x + bubble.dx * MAGNITUDE;
		bubble.y = bubble.y + bubble.dy * MAGNITUDE;
	}
}


