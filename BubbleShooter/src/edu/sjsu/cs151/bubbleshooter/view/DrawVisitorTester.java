package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.sjsu.cs151.bubbleshooter.model.Board;
import edu.sjsu.cs151.bubbleshooter.model.Model;

public class DrawVisitorTester 
{
	public static void main(String[] args)
	{
		BoardIcon boardIcon = new BoardIcon();
		JFrame frame = new JFrame("TEST");
		final JLabel label = new JLabel(boardIcon);
		
		frame.setLayout(new FlowLayout());
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
