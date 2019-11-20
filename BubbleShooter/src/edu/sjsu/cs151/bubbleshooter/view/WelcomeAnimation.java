package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import edu.sjsu.cs151.bubbleshooter.model.Bubble;

public class WelcomeAnimation extends JPanel{
	
	
	public WelcomeAnimation() {
		
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
		
		add(label);
		
		
		// 
		final int DELAY = 15;
	    // Milliseconds between timer ticks
	    Timer t = new Timer(DELAY, new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            
	            	// loop that goes through each bubble shown on the screen and
	            	// updates their position based on their velocity
	            	// then, checks if they are colliding with the border
	            	for(int i = 0; i < icon.getBubblesShown(); i++) { 
	            		shapes[i].translate();
	            		if(shapes[i].x <= 0 || shapes[i].x >= ICON_WIDTH - 2*BUBBLE_WIDTH)
	            			shapes[i].dx *= -1;
	            		if(shapes[i].y <= 0 || shapes[i].y >= ICON_HEIGHT - BUBBLE_WIDTH)
	            			shapes[i].dy *= -1;
	            	}
	               
	            	// increases the timer loop count by one
	            	loopCount++;
	            	
	            	// if this loop has gone 25 times, add one bubble to the animation
	            	// resets the loop count. Every 15 * 25 = 375 milliseconds
	            	if(loopCount > 25) {
	            		icon.setBubblesShown(icon.getBubblesShown() + 1);
	            		loopCount = 0;
	            	}
	            	// if the number of bubbles shown surpasses the 
	            	// number of bubbles, set them equal
	            	if(icon.getBubblesShown() > numBubbles)
	            		icon.setBubblesShown(numBubbles);

	            	// repaints the jlabel of icon.
	            	// icon holds the array of bubbles so it repaints all bubbles
	            	label.repaint();
	            }
	    	});
	    t.start();
	}
	
	
	
	private static final int BUBBLE_WIDTH = 30;
	public static final int ICON_HEIGHT = 500;
	public static final int ICON_WIDTH = 800;
	
	// maximum number of bubbles to be shown in the animation
	private static final int numBubbles = 200;
	
	// values used in timer loop
	public static int loopCount = 0;
}
