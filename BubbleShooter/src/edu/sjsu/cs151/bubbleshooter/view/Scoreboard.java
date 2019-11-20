package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class that controls and displays the Score.
 */

public class Scoreboard {
	
private int score;
	
	/**
	 * Constructs a Scoreboard object that sets the score to 0.
	 * @postcondition score is 0.
	 */
	public Scoreboard() {
		score = 0;
	}
	
	/**
	 * method that increases the Scoreboard score
	 * @param increment the amount to increase the score by.
	 * 
	 */
	public void increaseScore(int increment) {
		score += increment;
	}
	
	/**
	 * method that returns the score
	 * @return score the score of the Scoreboard
	 */
	public int getScore() {
		return score;
	}
	
	public static void main(String[] args) {
		JPanel scoreBoard = new JPanel();
		scoreBoard.setPreferredSize(new Dimension(400, 600));
		scoreBoard.setLayout(new BoxLayout(scoreBoard, BoxLayout.Y_AXIS));
		
		String name1 = "Max";
		String name2 = "Jack";
		String name3 = "Finn";
		String name4 = "Po";
		String name5 = "Horace";
		JLabel scoreLabel1 = new JLabel(name1 + " 500");
		JLabel scoreLabel2 = new JLabel(name2 + " 400");
		JLabel scoreLabel3 = new JLabel(name3 + " 300");
		JLabel scoreLabel4 = new JLabel(name4 + " 200");
		JLabel scoreLabel5 = new JLabel(name5 + " 100");
		
		scoreLabel1.setFont(new Font(scoreLabel1.getName(), Font.PLAIN, 20));
		scoreLabel1.setPreferredSize(new Dimension(400/5*2,600/10));
		scoreBoard.add(scoreLabel1);
		scoreLabel2.setFont(new Font(scoreLabel2.getName(), Font.PLAIN, 20));
		scoreLabel2.setPreferredSize(new Dimension(400/5*2,600/10));
		scoreBoard.add(scoreLabel2);
		scoreLabel3.setFont(new Font(scoreLabel3.getName(), Font.PLAIN, 20));
		scoreLabel3.setPreferredSize(new Dimension(400/5*2,600/10));
		scoreBoard.add(scoreLabel3);
		scoreLabel4.setFont(new Font(scoreLabel4.getName(), Font.PLAIN, 20));
		scoreLabel4.setPreferredSize(new Dimension(400/5*2,600/10));
		scoreBoard.add(scoreLabel4);
		scoreLabel5.setFont(new Font(scoreLabel5.getName(), Font.PLAIN, 20));
		scoreLabel5.setPreferredSize(new Dimension(400/5*2,600/10));
		scoreBoard.add(scoreLabel5);
		
		JPanel exit = new JPanel();
		exit.setLayout(new FlowLayout());
		
		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(event -> System.exit(0));
		quitButton.setPreferredSize(new Dimension(600/4, 400/10));
		
		exit.add(quitButton);
		
		JFrame frame = new JFrame("Scoreboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 600));
		frame.setLayout(new BorderLayout());
		
		frame.add(scoreBoard, BorderLayout.CENTER);
		frame.add(exit, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}

