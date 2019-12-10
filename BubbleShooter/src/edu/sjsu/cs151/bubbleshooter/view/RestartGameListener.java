package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.event.*;
import edu.sjsu.cs151.bubbleshooter.controller.*;
import edu.sjsu.cs151.bubbleshooter.model.Board;
/**
 * Handles when the restart button is pressed
 * @author maxpu
 *
 */
public class RestartGameListener implements ActionListener {
	/**
	 * the action that happens when the restart button is pressed
	 */
	public void actionPerformed(ActionEvent event) {
			
			try {
				Controller.messageQueue.put(new RestartGameMessage());
				System.out.println("test");
			}
			catch(InterruptedException exception) {
				exception.printStackTrace();
			}
	}

}
