package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.sjsu.cs151.bubbleshooter.model.Bubble;

public class View {
	
	private static final int BUBBLE_WIDTH = 30;
	private static final int ICON_HEIGHT = 500;
	private static final int ICON_WIDTH = 800;
	
	// maximum number of bubbles to be shown in the animation
	private static final int numBubbles = 200;
	
	// values used in timer loop
	public static int loopCount = 0;
	public static int bubblesShown = 0;
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bubble Shooter");
		
		// creates an array of BubbleShape objects the size of numBubbles
		BubbleShape[] shapes = new BubbleShape[numBubbles];
		
		// for each of these, instantiate them with their position
		// at the middle bottom of the screen
		for(int i = 0; i < numBubbles; i++) 
		{
			Bubble bub = new Bubble(null,null,null,null,null,null);
			shapes[i] = new BubbleShape(ICON_WIDTH / 2 - ( BUBBLE_WIDTH /2), ICON_HEIGHT - BUBBLE_WIDTH, BUBBLE_WIDTH, bub);
		}
		
		// create a ShapeIcon what the array of BubbleShapes
		ShapeIcon icon = new ShapeIcon(shapes, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		
		// set JFrame layout to FLowLayout and add the icon JLabel
		frame.setLayout(new FlowLayout());
		frame.add(label);
		
		// housekeeping to setup the JFrame window		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		// 
		final int DELAY = 15;
	    // Milliseconds between timer ticks
	    Timer t = new Timer(DELAY, new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            
	            	// loop that goes through each bubble shown on the screen and
	            	// updates their position based on their velocity
	            	// then, checks if they are colliding with the border
	            	for(int i = 0; i < bubblesShown; i++) { 
	            		shapes[i].translate();
	            		if(shapes[i].x <= 0 || shapes[i].x >= ICON_WIDTH - 2*BUBBLE_WIDTH)
	            			shapes[i].dx *= -1;
	            		if(shapes[i].y <= 0 || shapes[i].y >= ICON_HEIGHT - BUBBLE_WIDTH)
	            			shapes[i].dy *= -1;
	            	}
	               
	            	// repaints the jlabel of icon.
	            	// icon holds the array of bubbles so it repaints all bubbles
	            	label.repaint();
	               
	            	// increases the timer loop count by one
	            	loopCount++;
	            	
	            	// if this loop has gone 25 times, add one bubble to the animation
	            	// resets the loop count. Every 15 * 25 = 375 milliseconds
	            	if(loopCount > 25) {
	            		bubblesShown++;
	            		loopCount = 0;
	            	}
	            	// if the number of bubbles shown surpasses the 
	            	// number of bubbles, set them equal
	            	if(bubblesShown > numBubbles)
	            		bubblesShown = numBubbles;
	            }
	    	});
	    t.start();
	}
}
