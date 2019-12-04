package edu.sjsu.cs151.bubbleshooter.view;
import java.awt.*;

import edu.sjsu.cs151.bubbleshooter.controller.Visitor;
import edu.sjsu.cs151.bubbleshooter.model.*;

public class DrawVisitor implements Visitor
{
	private static final int WIDTH_OF_A_BUBBLE = 50;
	private BubbleShape bubbleShape;
	private Graphics2D g2;
	
	public DrawVisitor(Graphics g)
	{
		g2 = (Graphics2D) g;
	}
	
	public void visitBubble(Bubble bubble)
	{
		if(bubble != null)
		{
			bubbleShape = new BubbleShape(bubble.x*WIDTH_OF_A_BUBBLE + 100, bubble.y*WIDTH_OF_A_BUBBLE, WIDTH_OF_A_BUBBLE, bubble);
			bubbleShape.draw(g2);
		}
	}
	
	public void visitBorder()
	{
		BorderShape a = new BorderShape();
		a.draw(g2);
	}
}