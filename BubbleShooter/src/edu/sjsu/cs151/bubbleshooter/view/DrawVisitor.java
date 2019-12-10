package edu.sjsu.cs151.bubbleshooter.view;
import java.awt.*;

import edu.sjsu.cs151.bubbleshooter.controller.Visitor;
import edu.sjsu.cs151.bubbleshooter.model.*;
/**
 * Can visit a single bubble and draw it at the location of the bubble on the board.
 * @author maxpu
 *
 */
public class DrawVisitor implements Visitor
{
	private static final int WIDTH_OF_A_BUBBLE = 50;
	private BubbleShape bubbleShape;
	private Graphics2D g2;
	
	/**
	 * creates a DrawVisitor object
	 * @param g
	 */
	public DrawVisitor(Graphics g)
	{
		g2 = (Graphics2D) g;
	}
	/**
	 * visits a single bubble and draws it
	 */
	public void visitBubble(Bubble bubble)
	{
		if(bubble != null)
		{
			bubbleShape = new BubbleShape(bubble.x*WIDTH_OF_A_BUBBLE + 100, bubble.y*WIDTH_OF_A_BUBBLE, WIDTH_OF_A_BUBBLE, bubble);
			bubbleShape.draw(g2);
			
		}
		
	}
	/**
	 * visits a single border and draws it
	 */
	public void visitBorder()
	{
		BorderShape a = new BorderShape();
		a.draw(g2);
	}
}