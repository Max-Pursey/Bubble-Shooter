package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import edu.sjsu.cs151.bubbleshooter.controller.GameInfo;

/**
 * a class that deals with drawing a game over screen
 * @author maxpu
 *
 */
public class GameOverView extends JPanel
{
	private static int score;
	public static JLabel finalScore;
	private static final int GAME_HEIGHT = 400;
	private static final int GAME_WIDTH = 600;
	
	/**
	 * constructs a view of the game over screen
	 */
	public GameOverView()
	{
		setLayout(new BorderLayout());
		
		finalScore = new JLabel("Your score is: " + score);
		finalScore.setFont(new Font(finalScore.getName(), Font.PLAIN, 20));
		finalScore.setPreferredSize(new Dimension(GAME_WIDTH/5*2,GAME_HEIGHT/10));
		finalScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setPreferredSize(new Dimension(GAME_WIDTH/4, GAME_HEIGHT/10));
		quitButton.addActionListener(event -> System.exit(0));
		quitButton.setVerticalAlignment(SwingConstants.BOTTOM);
		
		add(finalScore, BorderLayout.CENTER);
		add(quitButton, BorderLayout.SOUTH);
	}
	/**
	 * returns the final score JLabel
	 * @return finalScore
	 */
	public static JLabel getFinalScore()
	{
		return finalScore;
	}
}
