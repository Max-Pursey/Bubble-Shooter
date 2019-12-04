package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Board;
import edu.sjsu.cs151.bubbleshooter.view.GameView;
import edu.sjsu.cs151.bubbleshooter.view.View;

public class RestartGameValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != RestartGameMessage.class) {
			return ValveResponse.MISS;
		}
		System.out.println("valve checkmark");
		// actions in model
		Board.getInstance().repopulateBoard();
		// actions in view
		View.returnToWelcome();
		GameView.label.repaint();
		return ValveResponse.EXECUTED;
	}

}
