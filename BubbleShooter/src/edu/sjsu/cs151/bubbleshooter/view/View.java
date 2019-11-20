package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class View {
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bubble Shooter");
		
		JPanel welcomeAnim = new WelcomeAnimation();
		
		JButton startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));

		frame.add(welcomeAnim, BorderLayout.NORTH);
		frame.add(startButton, BorderLayout.SOUTH);
		
		// housekeeping to setup the JFrame window		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//timer
		
		// frame.getContentPane().remove(welcomeAnim);
		// frame.getContentPane().remove(startButton);
		// frame.getContentPane().invalidate();
		// frame.getContentPane().
		
		//game view
	    
	}
}
