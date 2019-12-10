package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.geom.*;
import edu.sjsu.cs151.bubbleshooter.model.Bubble;
import java.awt.Color;

/**
 * this class creates a drawn bubble.
 * @author maxpu
 *
 */
public class BubbleShape {
	
	public double x;
	public double y;
	public double dx = ((Math.random()*10)-5);
	public double dy = (Math.random()*-5);
	private double width;
	private Bubble bub;
	/**
	 * constructs a bubble shape and initializes its variables.
	 * @param x
	 * @param y
	 * @param width
	 * @param thisBub
	 */
	public BubbleShape(double x, double y, double width, Bubble thisBub) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.bub = thisBub;
	}
	/**
	 * returns the width of a bubble
	 * @return width
	 */
	public double getIconWidth() {
		return width;
	}
	/**
	 * returns the height of a bubble
	 * @return width
	 */
	public double getIconHeight() {
		return width;
	}
	/**
	 * moves a bubble x distance horizontally and y distance vertically.
	 */
	public void translate() {
		x += dx;
		y += dy;
	}
	/**
	 * draws a bubble.
	 * @param g2
	 */
	public void draw(Graphics2D g2) {
		
		Ellipse2D.Double bubble = new Ellipse2D.Double(x + width/2, y, width, width);
		g2.setColor(bub.color);
		g2.fill(bubble);
		g2.draw(bubble);
		Ellipse2D.Double bubble2 = new Ellipse2D.Double(x + width/2, y, width, width);
		g2.setColor(Color.BLACK);
		g2.draw(bubble2);
		
	}
}
