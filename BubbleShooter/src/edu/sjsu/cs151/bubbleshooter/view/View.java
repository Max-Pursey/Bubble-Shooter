package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
	
	private static final int BUBBLE_WIDTH = 20;
	private static final int ICON_HEIGHT = 400;
	private static final int ICON_WIDTH = 500;
	public static double x = ((Math.random()*10)-5);
	public static double y = (Math.random()*-5);
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bubble view");
		final BubbleShape shape = new BubbleShape(250 - ( BUBBLE_WIDTH /2), 400 - BUBBLE_WIDTH, BUBBLE_WIDTH);
		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		//frame.setPreferredSize(new Dimension(400, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		
		
		final int DELAY = 15;
	      // Milliseconds between timer ticks
	      Timer t = new Timer(DELAY, new
	         ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	               shape.translate(x, y);
	               label.repaint();
	               if(shape.x <= 0 || shape.x >= ICON_WIDTH - BUBBLE_WIDTH)
	            	   x *= -1;
	               if(shape.y <= 0 || shape.y >= ICON_HEIGHT - BUBBLE_WIDTH)
	            	   y *= -1;
	            }
	         });
	      t.start();
	}
}
