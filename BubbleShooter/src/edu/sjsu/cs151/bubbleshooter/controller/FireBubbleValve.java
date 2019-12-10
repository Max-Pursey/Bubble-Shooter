package edu.sjsu.cs151.bubbleshooter.controller;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.GameOverView;
import edu.sjsu.cs151.bubbleshooter.view.GameView;
import edu.sjsu.cs151.bubbleshooter.view.View;
/**
 * class that handles the code of when a bubble is fired
 * @author maxpu
 *
 */
public class FireBubbleValve implements Valve {
	/**
	 * the code that handles when a bubble is fired
	 */
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
		gi.updateBoard();
		Bubble fired = gi.getAmmo().get(gi.getAmmo().size()-1);
		//System.out.println(fired.x + ", " + fired.y);
		Bubble[][] board = gi.getBoardInfo();
		
		fired.dx = dx;
		fired.dy = dy;
		CollisionVisitor cv = new CollisionVisitor(fired);
		while(cv.getCollision() == null) {
			
			/**for(Bubble[] bs : board)
			{
				for(Bubble b : bs) {
					cv.visitBubble(b);
				}
			}**/
			Board.visit(cv);
			
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
		/**Bubble firstCollided = cv.getCollision();
		// set bubble x and y to appropriate final locations
		
		int j = -1;
		if(fired.x > firstCollided.x)
			j = 1;
		
		if(fired.y - firstCollided.dy < .5) {
			fired.x = firstCollided.x + (.5 * j);
			fired.y = firstCollided.y - Math.sqrt(3)/2;
		}
		else if(fired.y - firstCollided.y > .5) {
			fired.x = firstCollided.x + (.5 * j);
			fired.y = firstCollided.y + Math.sqrt(3)/2;
		}
		else {
			fired.x = firstCollided.x + j;
			fired.y = firstCollided.y;
		}**/
		
		
		// set bubble dx, dy to 0
		
		fired.dx = 0;
		fired.dy = 0;
		
	
		
		// add bubble to board
		
		//double newX = Math.round(fired.x - 0.25);
		//double newY = (fired.y * (2 / Math.sqrt(3))) + Math.sqrt(3) *2;
		
		Board.settleBubble(fired);
		Board.ammo.remove(gi.getAmmo().get(gi.getAmmo().size() - 1));
		GameView.label.repaint();
		
		
				
		// check combinations and pop if possible
		
		popped = false;
		popList = new ArrayList<Bubble>();
		Model.checkCombinations(fired);
		for(Bubble[] b : gi.getBoardInfo()) {
			for(Bubble bubble : b) {
				if(bubble != null && bubble.marked)
					popList.add(bubble);
			}
		}
		
		
		
		GameView.label.repaint();
		
		
		
		if(popList.size() >= 3) {
			System.out.println("marked pop: " + popList.size());
			Model.pop(popList);
			popped = true;
			popList.clear();
			for(int i = 0; i < gi.getBoardInfo().length; i++) {
				if(gi.getBoardInfo()[i][0] != null)
					Model.checkConnected(gi.getBoardInfo()[i][0]);
			}
			for(Bubble[] c : gi.getBoardInfo()) {
				for(Bubble bubblec : c) {
					if(bubblec != null && !bubblec.connected)
						popList.add(bubblec);
				}
			}
			if(popList.size() > 0) {
				System.out.println("connected pop: " + popList.size());
				Model.pop(popList);
				popList.clear();
			}
		}
		else {
			System.out.println("failed marked pop: " + popList.size());
			for(Bubble[] b : gi.getBoardInfo()) {
				for(Bubble bubble : b) {
					if(bubble != null && bubble.marked)
						bubble.setMarked(false);
				}
			}
		}
		gi.updateBoard();
		for(Bubble[] b : gi.getBoardInfo()) {
			for(Bubble bubble : b) {
				if(bubble != null)
					bubble.setConnected(false);
			}
		}
		
		GameView.label.repaint();
		
		
		
		// check connected
		
		
		
		
		
		
	
		
		// increment ammo appropriately
		// by default removes bubble from ammo, if 3 or more popped, add a new bubble to ammo.
		
		temp = new ArrayList<Bubble>();
		if(popped == true) {
			temp.addAll(gi.getAmmo());
			Board.ammo.clear();
			Board.ammo.add(new Bubble(null, null, null, null, null, null));
			Board.ammo.addAll(temp);		
		}
		
		
		
		if(gi.getAmmo().isEmpty()) {
			//Board.numAmmo--;
			Board.fillAmmo();
			Model.addRow();
			GameView.label.repaint();
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gi.updateBoard();
			/*
			for(int i = 0; i < gi.getBoardInfo().length; i++) {
			if(gi.getBoardInfo()[i][0] != null)
				Model.checkConnected(gi.getBoardInfo()[i][0]);
			}
			for(Bubble[] c : gi.getBoardInfo()) {
			for(Bubble bubblec : c) {
				if(bubblec != null && !bubblec.connected)
					popList.add(bubblec);
				}
			}
			if(popList.size() > 0) {
				Model.pop(popList);
				System.out.println("New Island Pop");
				popList.clear();
			}
			*/
		
		}
		
		// check for new islands
		
		
		// update view
		
		Board.allignAmmo();
		GameView.scoreLabel.setText("Score:   " + Model.score);
		GameView.label.repaint();
		
		for(int x = 0; x < Board.board.length; x++)
		{
			if(Board.board[x][10] != null)
			{
				GameOverView.finalScore.setText("Your score is: " + gi.getScore());
				View.gameOverScreen();
			}
		}
		
		return ValveResponse.EXECUTED;
	}
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	private boolean popped;
	private ArrayList<Bubble> popList;
	private ArrayList<Bubble> temp;
}