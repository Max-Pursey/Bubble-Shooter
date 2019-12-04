package edu.sjsu.cs151.bubbleshooter.controller;

public class RestartGameValve implements Valve {
	
	public ValveResponse execute(Message message) {
		if(message.getClass() != RestartGameMessage.class) {
			return ValveResponse.MISS;
		}
		// actions in model
		// actions in view
		return ValveResponse.EXECUTED;
	}

}
