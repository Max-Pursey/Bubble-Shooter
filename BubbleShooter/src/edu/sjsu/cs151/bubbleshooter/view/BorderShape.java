package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * a class that creates a border for the game board.
 * @author maxpu
 *
 */
public class BorderShape {
	/**
	 * this method draws the border.
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		g2.setColor(Color.LIGHT_GRAY);
		g2.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	}
	
	private static final int RECT_X = 125;
	private static final int RECT_Y = 0; 
	private static final int RECT_WIDTH = 525;
	private static final int RECT_HEIGHT = 483;
}