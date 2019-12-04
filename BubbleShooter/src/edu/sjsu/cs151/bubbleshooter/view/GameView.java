package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;

import javax.swing.*;
import edu.sjsu.cs151.bubbleshooter.model.Board;
import edu.sjsu.cs151.bubbleshooter.model.Bubble;

public class GameView extends JPanel {
	
	public JLabel label;

	public GameView() {


		setLayout(new BorderLayout());

		
	 
		JPanel game = new JPanel();
		game.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT+100));
		
		BoardIcon boardIcon = new BoardIcon();
		label = new JLabel(boardIcon);
		label.addMouseListener(new FireBubbleListener());
		game.add(label);
				
		// for each of these, instantiate them with their position
		// at the middle bottom of the screen

		JPanel info = new JPanel();
		info.setLayout(new FlowLayout());
		
		JButton restartButton = new JButton("Restart");
		restartButton.setPreferredSize(new Dimension(GAME_WIDTH/4, GAME_HEIGHT/10));
		restartButton.addMouseListener(new FireBubbleListener());
		
		JLabel scoreLabel = new JLabel("Score:   " + game_score);
		scoreLabel.setFont(new Font(scoreLabel.getName(), Font.PLAIN, 20));
		scoreLabel.setPreferredSize(new Dimension(GAME_WIDTH/5*2,GAME_HEIGHT/10));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setPreferredSize(new Dimension(GAME_WIDTH/4, GAME_HEIGHT/10));
		quitButton.addActionListener(event -> System.exit(0));
		
		info.add(restartButton);
		info.add(scoreLabel);
		info.add(quitButton);
		
		
		add(game, BorderLayout.NORTH);
		add(info, BorderLayout.SOUTH);
		
	}
	
	public static JLabel label;
	
	private static int game_score = 330;
	private static final int GAME_HEIGHT = 400;
	private static final int GAME_WIDTH = 600;
}