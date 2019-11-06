package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.geom.*;
import edu.sjsu.cs151.bubbleshooter.model.Bubble;
import java.awt.Color;

public class BubbleShape {
	
	public double x;
	public double y;
	public double dx = ((Math.random()*10)-5);
	public double dy = (Math.random()*-5);
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
	
	public void translate() {
		x += dx;
		y += dy;
	}
	
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
