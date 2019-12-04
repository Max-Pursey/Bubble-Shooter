package edu.sjsu.cs151.bubbleshooter.controller;

public class FireBubbleValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != FireBubbleMessage.class) {
			return ValveResponse.MISS;
		}
		// actions in model
		// actions in view
		return ValveResponse.EXECUTED;
	}
}
