package Model;

import java.awt.Graphics2D;

import Controller.BubbleShooter;

/**
 * A class that displays board, bubbles, and bubble shooter
 * Singleton pattern
 */
public final class Board {

	private static final Board INSTANCE = new Board();
	
	/**
	 * Constructs a Board object that holds the bubbles and the bubble shooter.
	 * Creating a new board restarts the game by creating the field of random bubbles
	 * and a new bubble shooter
	 */
	private Board() {
		BubbleShooter shooter = new BubbleShooter();
	}
	
	public static Board getInstance() {
		return INSTANCE
	}
	
	/**
	 *  Paint components of the board 
	 *  @param g the Graphics2D object
	 */
	public void paint(Graphics2D g) {
		
	}
}
