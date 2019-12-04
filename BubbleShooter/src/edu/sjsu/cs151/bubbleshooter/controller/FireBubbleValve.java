package edu.sjsu.cs151.bubbleshooter.controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import edu.sjsu.cs151.bubbleshooter.model.*;

public class FireBubbleValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != FireBubbleMessage.class) {
			return ValveResponse.MISS;
		}
		PointerInfo a = MouseInfo.getPointerInfo();
		Point p = a.getLocation();
		x = p.getX() - 415;
		y = (p.getY() - 495) * -1 ;
		
		
		System.out.println(x + ", " + y);
		double q = Math.sqrt((x*x)+(y*y));
		dx = x/q;
		dy = y/q;
		System.out.println(dx + ", " + dy);
		GameInfo gi = new GameInfo();
		Bubble fired = gi.getAmmo().get(gi.getAmmo().size());
		Bubble[][] board = gi.getBoardInfo();
		fired.dx = dx;
		fired.dy = dy;
		CollisionVisitor cv = new CollisionVisitor(fired);
		
		while(cv.getCollision() != null || fired.y <= 0) {
		// actions in model
		for(Bubble[] bs : board)
		{
			for(Bubble b : bs) {
				cv.visitBubble(b);
			}
		}
		
		// update view
			
		// increment bubble's location
		
		// if x is out of boundaries, flip the dx
		}
		
		// set bubble x and y to appropriate final locations
		
		// set bubble dx, dy to 0
		
		// update view
		
		
		return ValveResponse.EXECUTED;
	}
	
	private double x;
	private double y;
	private double dx;
	private double dy;
}