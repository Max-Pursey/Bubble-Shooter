package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.*;
import javax.swing.*;

/**
 * A class that controls and displays the Score.
 */
public class Scoreboard extends JPanel 
{	
	public Scoreboard() 
	{
		setPreferredSize(new Dimension(800, 1000));
		setLayout(new BorderLayout());
		
		JPanel textBoard = new JPanel();
		textBoard.setLayout(new BoxLayout(textBoard, BoxLayout.Y_AXIS));
		
		String name1 = "";
		String name2 = "";
		String name3 = "";
		String name4 = "";
		String name5 = "";
		JLabel scoreLabel1 = new JLabel(name1 + " 500", JLabel.CENTER);
		JLabel scoreLabel2 = new JLabel(name2 + " 400", JLabel.CENTER);
		JLabel scoreLabel3 = new JLabel(name3 + " 300", JLabel.CENTER);
		JLabel scoreLabel4 = new JLabel(name4 + " 200", JLabel.CENTER);
		JLabel scoreLabel5 = new JLabel(name5 + " 100", JLabel.CENTER);
		
		scoreLabel1.setFont(new Font(scoreLabel1.getName(), Font.PLAIN, 50));
		scoreLabel1.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		textBoard.add(scoreLabel1);
		scoreLabel2.setFont(new Font(scoreLabel2.getName(), Font.PLAIN, 50));
		scoreLabel2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		textBoard.add(scoreLabel2);
		scoreLabel3.setFont(new Font(scoreLabel3.getName(), Font.PLAIN, 50));
		scoreLabel3.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		textBoard.add(scoreLabel3);
		scoreLabel4.setFont(new Font(scoreLabel4.getName(), Font.PLAIN, 50));
		scoreLabel4.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		textBoard.add(scoreLabel4);
		scoreLabel5.setFont(new Font(scoreLabel5.getName(), Font.PLAIN, 50));
		scoreLabel5.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		textBoard.add(scoreLabel5);
		
		add(textBoard, BorderLayout.NORTH);
		
		JButton quitButton = new JButton("Back to Menu");
		quitButton.addActionListener(event -> View.returnToWelcome());
		quitButton.setPreferredSize(new Dimension(600/4, 400/10));
		
		add(quitButton, BorderLayout.SOUTH);
	}
	
	public static void backToMenu() {
		
	}
}

