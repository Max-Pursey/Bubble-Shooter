package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.event.*;
import edu.sjsu.cs151.bubbleshooter.controller.*;
import edu.sjsu.cs151.bubbleshooter.model.Board;

public class RestartGameListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
			Board.getInstance().repopulateBoard();		
			GameView.label.repaint();
	}

}
