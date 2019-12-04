package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Board;
import edu.sjsu.cs151.bubbleshooter.view.View;

public class RestartGameValve implements Valve {
	
	public ValveResponse execute(Message message) {
		if(message.getClass() != RestartGameMessage.class) {
			return ValveResponse.MISS;
		}
		// actions in model
		Board.getInstance().repopulateBoard();
		GameInfo restartedGame = new GameInfo();
		// actions in view
		View.getGameView()
		return ValveResponse.EXECUTED;
	}

}
