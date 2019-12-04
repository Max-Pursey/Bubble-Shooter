package edu.sjsu.cs151.bubbleshooter.view;

import edu.sjsu.cs151.bubbleshooter.controller.*;


public class RestartGameListener implements ActionListener {
	public void actionPerformed(Action event) {
		try {
			queue.put(new RestartGameMessage());
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
	}

}
