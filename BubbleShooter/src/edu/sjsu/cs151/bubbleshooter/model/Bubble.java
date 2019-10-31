package edu.sjsu.cs151.bubbleshooter.model;

import java.awt.Color;

public class Bubble 
{	
	public Bubble 	left;
	public Bubble 	right;
	public Bubble 	topLeft;
	public Bubble 	topRight;
	public Bubble 	bottomLeft;
	public Bubble 	bottomRight;
	public Color 	color;
	public String 	colorString;
	public boolean 	marked;
	public double 		x;
	public double 		y;
	public double 		dx;
	public double 		dy;
	
	public Bubble(Bubble thisLeft, Bubble thisRight, Bubble thisTopLeft, Bubble thisTopRight, Bubble thisBottomLeft, 
	Bubble thisBottomRight)
	{
		left = thisLeft;
		if (thisLeft != null) {
			thisLeft.right = this;
		}
		right = thisRight;
		if (thisRight != null) {
			thisRight.left = this;
		}
		topLeft = thisTopLeft;
		if (thisTopLeft != null) {
			thisTopLeft.bottomRight = this;
		}
		topRight = thisTopRight;
		if (thisTopRight != null) {
			thisTopRight.bottomLeft = this;
		}
		bottomLeft = thisBottomLeft;
		if (thisBottomLeft != null) {
			thisBottomLeft.topRight = this;
		}
		bottomRight = thisBottomRight;
		if (thisBottomRight != null) {
			thisBottomRight.topLeft = this;
		}
		color = this.randomColor();
	}
	
	
	public Color randomColor() {
		double randNumber = Math.random() * 6;
		
		if		(randNumber > 5) 	{ colorString = " Red  "; return Color.RED; 	}
		else if	(randNumber > 4) 	{ colorString = "Yellow"; return Color.YELLOW; 	}
		else if	(randNumber > 3)	{ colorString = "Green "; return Color.GREEN; 	}
		else if	(randNumber > 2)	{ colorString = " Cyan "; return Color.CYAN; 	}
		else if	(randNumber > 1)	{ colorString = " Blue "; return Color.BLUE; 	}
		else						{ colorString = " Pink "; return Color.PINK; 	}
	}	
	
	
	public void flipMarked() { marked = !marked; }
	
	
	public String toString() { return colorString; }
}
