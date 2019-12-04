package edu.sjsu.cs151.bubbleshooter.controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class FireBubbleValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != FireBubbleMessage.class) {
			return ValveResponse.MISS;
		}
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		System.out.println((int) b.getX() + ", " + (int)b.getY());
		// actions in model
		// actions in view
		return ValveResponse.EXECUTED;
	}
}