package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Board;
import edu.sjsu.cs151.bubbleshooter.view.GameView;
import edu.sjsu.cs151.bubbleshooter.view.View;
/**
 * handles the code for when the game is reset
 * @author maxpu
 *
 */
public class RestartGameValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != RestartGameMessage.class) {
			return ValveResponse.MISS;
		}
		// actions in model
		System.out.println("test2"); 
		GameInfo gameinfo = new GameInfo();
		Board.getInstance().repopulateBoard();
		// actions in view
		GameView.label.repaint();
		return ValveResponse.EXECUTED;
		
		
	}

}
