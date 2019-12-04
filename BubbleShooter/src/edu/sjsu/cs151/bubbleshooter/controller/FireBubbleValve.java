package edu.sjsu.cs151.bubbleshooter.controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.GameView;

public class FireBubbleValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != FireBubbleMessage.class) {
			return ValveResponse.MISS;
		}
		PointerInfo a = MouseInfo.getPointerInfo();
		Point p = a.getLocation();
		if(p.getX() < 0)
			return ValveResponse.EXECUTED;
		x = p.getX() - 415;
		y = (p.getY() - 495) * -1 ;
		
		
		//System.out.println(x + ", " + y);
		double q = Math.sqrt((x*x)+(y*y));
		dx = x/q;
		dy = y/q;
		//System.out.println(dx + ", " + dy);
		GameInfo gi = new GameInfo();
		Bubble fired = gi.getAmmo().get(gi.getAmmo().size()-1);
		//System.out.println(fired.x + ", " + fired.y);
		Bubble[][] board = gi.getBoardInfo();
		fired.dx = dx;
		fired.dy = dy;
		CollisionVisitor cv = new CollisionVisitor(fired);
		System.out.println(fired.x + ", " + fired.y);
		while(cv.getCollision() != null && fired.y >= 0) {
			
		for(Bubble[] bs : board)
		{
			for(Bubble b : bs) {
				cv.visitBubble(b);
			}
		}
		
		// update view
		GameView.label.repaint();
			
		// increment bubble's location
		fired.x += fired.dx;
		fired.y += -fired.dy;
		
		// if x is out of boundaries, flip the dx
		if(fired.x <= 125 || fired.x >= 650)
			fired.dx *= -1;
		System.out.println(fired.x + ", " + fired.y);
		}

		
		// set bubble x and y to appropriate final locations
		
		// set bubble dx, dy to 0
		
		// remove bubble from ammo
		
		// check combinations and pop if possible
		
		// increment ammo appropriately
		
		// update view
		GameView.label.repaint();
		
		return ValveResponse.EXECUTED;
	}
	
	private double x;
	private double y;
	private double dx;
	private double dy;
}