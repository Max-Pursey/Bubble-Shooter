package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
	
	private static final int BUBBLE_WIDTH = 20;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bubble view");
		final BubbleShape shape = new BubbleShape(0, 0, BUBBLE_WIDTH);
		ShapeIcon icon = new ShapeIcon(shape, (int)(Math.random() * 400), (int)(Math.random() * 300));
		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		//frame.setPreferredSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		int x = 1;
		int y = 1;
		
		final int DELAY = 50;
	      // Milliseconds between timer ticks
	      Timer t = new Timer(DELAY, new
	         ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	               shape.translate(x, y);
	               label.repaint();
	            }
	         });
	      t.start();
	}
}
