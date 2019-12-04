package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import edu.sjsu.cs151.bubbleshooter.controller.Visitor;
import edu.sjsu.cs151.bubbleshooter.controller.GameInfo;

public class BoardIcon implements Icon
{
	private static final int BOARD_HEIGHT = 500;
	private static final int BOARD_WIDTH = 800;
	private static final int WIDTH_OF_A_BUBBLE = 50;
	private BubbleShape bubbleShape;
	private Graphics2D g2;
	
	public int getIconHeight() 
	{
		return BOARD_HEIGHT;
	}

	public int getIconWidth() 
	{
		return BOARD_WIDTH;
	}
	
	public void visit(Visitor visitor)
	{
		GameInfo gameInfo = new GameInfo();
		for(int y = 0; y < gameInfo.getBoardInfo().length; y++)
		{
			for(int x = 0; x < gameInfo.getBoardInfo()[y].length; x++)
			{
				visitor.visitBubble(gameInfo.getBoardInfo()[x][y]);	
			}
		}
		for(int i = 0; i < gameInfo.getAmmo().size()-1; i++)
		{
			// 0.8660254038 is the actual y coordinate of a bubble * 10 to put it under the game board.
			bubbleShape = new BubbleShape(i*WIDTH_OF_A_BUBBLE + 100, 0.8660254038*WIDTH_OF_A_BUBBLE, WIDTH_OF_A_BUBBLE, gameInfo.getAmmo().get(i));
			bubbleShape.draw(g2);
		}
	}

	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
	    visit(new DrawVisitor(g));
	}

}
