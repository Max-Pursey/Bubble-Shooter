package edu.sjsu.cs151.bubbleshooter.controller;


/**
 * handles the code for when a game over happens
 * @author maxpu
 *
 */
public class GameOverValve implements Valve {
	/**
	 * the code where game over happens
	 */
	public ValveResponse execute(Message message) {
		if(message.getClass() != RestartGameMessage.class) {
			return ValveResponse.MISS;
		}
		
		// temporary
		System.out.println("GameOver");
		
		
		// actions in model
		
		// actions in view
		
		return ValveResponse.EXECUTED;
	}
}
