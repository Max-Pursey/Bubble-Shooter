package edu.sjsu.cs151.bubbleshooter.controller;



public class GameOverValve implements Valve {
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
