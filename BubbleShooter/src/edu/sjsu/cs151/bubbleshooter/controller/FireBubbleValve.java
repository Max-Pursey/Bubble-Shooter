package edu.sjsu.cs151.bubbleshooter.controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
		double q = Math.sqrt((x*x)+(y*y))*10;
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
		while(cv.getCollision() == null) {
			
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
			
			if(fired.x < 0 || fired.x > 9.5)
				fired.dx *= -1;
			
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Bubble firstCollided = cv.getCollision();
		// set bubble x and y to appropriate final locations
		
		int i = -1;
		if(fired.x > firstCollided.x)
			i = 1;
		
		if(fired.y - firstCollided.dy < .5) {
			fired.x = firstCollided.x + (.5 * i);
			fired.y = firstCollided.y - Math.sqrt(3)/2;
		}
		else if(fired.y - firstCollided.y > .5) {
			fired.x = firstCollided.x + (.5 * i);
			fired.y = firstCollided.y + Math.sqrt(3)/2;
		}
		else {
			fired.x = firstCollided.x + i;
			fired.y = firstCollided.y;
		}
		
		
		// set bubble dx, dy to 0
		
		fired.dx = 0;
		fired.dy = 0;
		
		
		// add bubble to board
		
		//double newX = Math.round(fired.x - 0.25);
		//double newY = (fired.y * (2 / Math.sqrt(3))) + Math.sqrt(3) *2;
		
		Board.settleBubble(fired);
		
				
		// check combinations and pop if possible
		
		popped = false;
		markedList = new ArrayList<Bubble>();
		Model.checkCombinations(fired);
		for(Bubble[] b : gi.getBoardInfo()) {
			for(Bubble bubble : b) {
				if(bubble != null && bubble.marked)
					markedList.add(bubble);
			}
		}
		if(markedList.size() >= 3) {
			Model.pop(markedList);
			popped = true;
		}
		else {
			for(Bubble markedBub : markedList)
				markedBub.setMarked(false);
		}
		
		
		// remove bubble from ammo
		
		
		Board.ammo.remove(gi.getAmmo().get(gi.getAmmo().size() - 1));
		
		
		
		// increment ammo appropriately
		// by default removes bubble from ammo, if 3 or more popped, add a new bubble to ammo.
		
		temp = new ArrayList<Bubble>();
		if(popped == true) {
			temp.addAll(gi.getAmmo());
			Board.ammo.clear();
			Board.ammo.add(new Bubble(null, null, null, null, null, null));
			Board.ammo.addAll(temp);		
		}
		
		System.out.println(gi.getAmmo().size());
		if(gi.getAmmo().isEmpty()) {
			Board.numAmmo--;
			Board.fillAmmo();
			Model.addRow();
		}
		
		// update view
		
		Board.allignAmmo();
		GameView.scoreLabel.setText("Score:   " + Model.score);
		GameView.label.repaint();
		
		return ValveResponse.EXECUTED;
	}
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	private boolean popped;
	private ArrayList<Bubble> markedList;
	private ArrayList<Bubble> temp;
}