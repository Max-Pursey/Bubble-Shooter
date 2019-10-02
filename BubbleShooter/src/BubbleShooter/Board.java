package BubbleShooter;

import java.awt.Graphics2D;

/**
 * A class that displays board, bubbles, and bubble shooter
 */
public class Board {

	/**
	 * Constructs a Board object that holds the bubbles and the bubble shooter.
	 * Creating a new board restarts the game by creating the field of random bubbles
	 * and a new bubble shooter
	 */
	public Board() {
		BubbleShooter shooter = new BubbleShooter();
	}
	
	/**
	 *  Paint components of the board 
	 *  @param g the Graphics2D object
	 */
	public void paint(Graphics2D g) {
		
	}
}
