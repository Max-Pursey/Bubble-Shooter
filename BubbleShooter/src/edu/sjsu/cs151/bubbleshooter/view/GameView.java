package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;

import javax.swing.*;

public class GameView {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Border Layout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		
		JPanel game = new JPanel();
		game.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		
		
		JPanel info = new JPanel();
		info.setLayout(new FlowLayout());
		
		JButton restartButton = new JButton("Restart");
		restartButton.setPreferredSize(new Dimension(GAME_WIDTH/4, GAME_HEIGHT/10));
		// will call method in game that restarts 
		//restartButton.addActionListener(event -> );
		
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
		
		
		frame.add(game, BorderLayout.NORTH);
		frame.add(info, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private static int game_score = 330;
	
	private static final int GAME_HEIGHT = 400;
	private static final int GAME_WIDTH = 600;
}
