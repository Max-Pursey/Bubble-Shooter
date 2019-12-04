package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.event.*;
import edu.sjsu.cs151.bubbleshooter.controller.*;

public class RestartGameListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		try {
			Controller.messageQueue.put(new RestartGameMessage());
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
		
		GameView.label.repaint();
	}

}
