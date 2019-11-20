package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import javax.swing.*;


public class View {
	
	private static JFrame frame;
	private static JPanel welcomeAnim;
	private static JButton startButton;
	private static JPanel gameView;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Bubble Shooter");
		
		welcomeAnim = new WelcomeAnimation();
		
		startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));
		startButton.addActionListener(event -> startGame());
		
		gameView = new GameView();

		frame.add(welcomeAnim, BorderLayout.NORTH);
		frame.add(startButton, BorderLayout.SOUTH);
		
		// housekeeping to setup the JFrame window		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void startGame() {
		frame.getContentPane().remove(welcomeAnim);
		frame.getContentPane().remove(startButton);
		frame.getContentPane().add(gameView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
}
