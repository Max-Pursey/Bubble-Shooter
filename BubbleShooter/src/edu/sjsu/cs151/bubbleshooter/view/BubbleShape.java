package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.geom.*;
import edu.sjsu.cs151.bubbleshooter.model.Bubble;

public class BubbleShape {
	
	private int x;
	private int y;
	private int width;
	private Bubble bub;
	
	public BubbleShape(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.bub = new Bubble(null,null,null,null,null,null);
	}
	
	public int getIconWidth() {
		return width;
	}
	
	public int getIconHeight() {
		return width;
	}
	
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void draw(Graphics2D g2) {
		
		Ellipse2D.Double bubble = new Ellipse2D.Double(x + width/2, y, width, width);
		g2.setColor(bub.color);
		g2.fill(bubble);
		g2.draw(bubble);
		
	}
}
