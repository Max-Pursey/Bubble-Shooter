package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

import edu.sjsu.cs151.bubbleshooter.controller.Message;


public class View extends JFrame{
	
	private static JFrame frame;
	private static JPanel welcomeAnim;
	private static JPanel gameView;
	private static JPanel scoreboardView;
	private static JButton startButton;
	private static JButton scoreButton;
	
	public static View init(BlockingQueue<Message> queue) {
		return new View();
		// temporary code
	}
	
	public View() {
		
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
		scoreboardView = new Scoreboard();
		frame.getContentPane().add(scoreboardView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	
	public static void returnToWelcome() {
		frame.getContentPane().removeAll();
		welcomeAnim = new WelcomeAnimation();
		ShapeIcon.bubblesShown = 0;
		startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));
		startButton.addActionListener(event -> startGame());
		scoreButton = new JButton("Scoreboard");
		scoreButton.setPreferredSize(new Dimension(WelcomeAnimation.ICON_WIDTH, 40));
		scoreButton.addActionListener(event -> startScoreboard());
		frame.getContentPane().add(welcomeAnim, BorderLayout.NORTH);
		frame.getContentPane().add(startButton, BorderLayout.CENTER);
		frame.getContentPane().add(scoreButton, BorderLayout.SOUTH);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	
	public static JPanel getGameView()
	{
		return gameView;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
