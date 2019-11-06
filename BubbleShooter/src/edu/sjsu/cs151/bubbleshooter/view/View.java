package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
	
	private static final int BUBBLE_WIDTH = 25;
	private static final int ICON_HEIGHT = 400;
	private static final int ICON_WIDTH = 500;
	private static BubbleShape[] shapes;
	public static int loopCount = 0;
	public static int bubblesShown = 1;
	
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bubble view");
		
		int numBubbles = 500;
		shapes = new BubbleShape[numBubbles];
		for(int i = 0; i < numBubbles; i++) {
			final BubbleShape shape = new BubbleShape(250 - ( BUBBLE_WIDTH /2), 400 - BUBBLE_WIDTH, BUBBLE_WIDTH);
			shapes[i] = shape;
		}
		ShapeIcon icon = new ShapeIcon(shapes, ICON_WIDTH, ICON_HEIGHT);
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
	               for(int i = 0; i < bubblesShown; i++) { 
	            	   shapes[i].translate();
	            	   if(shapes[i].x <= 0 || shapes[i].x >= ICON_WIDTH - BUBBLE_WIDTH)
		            	   shapes[i].dx *= -1;
		               if(shapes[i].y <= 0 || shapes[i].y >= ICON_HEIGHT - BUBBLE_WIDTH)
		            	   shapes[i].dy *= -1;
	               }
	               label.repaint();
	               loopCount++;
	               if(loopCount > 30) {
	            	   bubblesShown++;
	            	   loopCount = 0;
	               }
	               if(bubblesShown > numBubbles)
	            	   bubblesShown = numBubbles;
	            }
	         });
	      t.start();
	}
}
