package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

import edu.sjsu.cs151.bubbleshooter.model.Board;

public class BoardIcon implements Icon
{
	private static final int BOARD_HEIGHT = 500;
	private static final int BOARD_WIDTH = 800;
	
	public int getIconHeight() 
	{
		return BOARD_HEIGHT;
	}

	public int getIconWidth() 
	{
		return BOARD_WIDTH;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) 
	{
	    Board.getInstance().visit(new DrawVisitor(g));
	}

}
