package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import javax.swing.*;


public class View {
	
	private static JFrame frame;
	private static JPanel welcomeAnim;
	private static JPanel gameView;
	private static JPanel scoreboardView;
	private static JButton startButton;
	private static JButton scoreButton;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Bubble Shooter");
		
		welcomeAnim = new WelcomeAnimation();
		
		startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));
		startButton.addActionListener(event -> startGame());
		
		scoreButton = new JButton("Scoreboard");
		scoreButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));
		scoreButton.addActionListener(event -> startScoreboard());
		
		gameView = new GameView();
		scoreboardView = new Scoreboard();

		frame.add(welcomeAnim, BorderLayout.NORTH);
		frame.add(startButton, BorderLayout.CENTER);
		frame.add(scoreButton, BorderLayout.SOUTH);
		
		// housekeeping to setup the JFrame window		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void startGame() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	
	public static void startScoreboard() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(scoreboardView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
}
