package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import java.util.concurrent.BlockingQueue;

import javax.swing.*;

import edu.sjsu.cs151.bubbleshooter.controller.Message;

/**
 * the view object that handles all the visual aspects of the game
 * @author maxpu
 *
 */
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
	/**
	 * creates the View object and handles drawing all visual aspects of the game.
	 */
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
	/**
	 * handles drawing the board of the game.
	 */
	public static void startGame() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	/**
	 * handles drawing the scoreboard.
	 */
	public static void startScoreboard() {
		frame.getContentPane().removeAll();
		scoreboardView = new Scoreboard();
		frame.getContentPane().add(scoreboardView);
		frame.getContentPane().invalidate();
		frame.getContentPane().validate();
	}
	/**
	 * handles going back to and redrawing the welcome screen.
	 */
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
	/**
	 * returns the GameView
	 * @return gameView
	 */
	public static JPanel getGameView()
	{
		return gameView;
	}

}
