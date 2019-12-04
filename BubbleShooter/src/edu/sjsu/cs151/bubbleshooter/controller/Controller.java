package edu.sjsu.cs151.bubbleshooter.controller;

import java.util.*;
import java.util.concurrent.*;
import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.View;



public class Controller {
	
	public static BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
	private Board gameinfo;
	private List<Valve> valves = new LinkedList<Valve>();
	
	
	public Controller(View view, Model model, BlockingQueue<Message> queue) {
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
		valves.add(new FireBubbleValve());
	}
	
	
	public void mainLoop() {
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while(response != ValveResponse.FINISH) {
			try {
				message = (Message)messageQueue.take();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			for(Valve valve : valves) {
				response = valve.execute(message);
				if(response != ValveResponse.MISS)
					break;
			}
		}
	}
	
	public void updateGameInfo() {
		
	}
}
