package edu.sjsu.cs151.bubbleshooter.view;
import java.awt.*;

import edu.sjsu.cs151.bubbleshooter.model.*;

public class DrawVisitor implements Visitor 
{
	private static final double RADIUS_OF_A_BUBBLE = 0.5;
	private BubbleShape bubbleShape;
	
	public DrawVisitor()
	{}
	
	public void visitBubble(Bubble bubble)
	{
		if(bubble != null)
		{
			bubbleShape = new BubbleShape(bubble.x, bubble.y, RADIUS_OF_A_BUBBLE*2, bubble);
			
		}
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
	   {
	      Graphics2D g2 = (Graphics2D) g;
	      bubbleShape.draw(g2);
	   }
	}
}


