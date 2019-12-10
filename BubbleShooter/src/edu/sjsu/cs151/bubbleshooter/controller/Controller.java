package edu.sjsu.cs151.bubbleshooter.controller;

import java.util.*;
import java.util.concurrent.*;
import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.View;


/**
 * handles the communication between model and view
 * @author maxpu
 *
 */
public class Controller {
	
	public static BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
	private List<Valve> valves = new LinkedList<Valve>();
	
	/**
	 * creates a Controller object
	 * @param view
	 * @param model
	 * @param queue
	 */
	public Controller(View view, Model model, BlockingQueue<Message> queue) {
		this.view = view;
		this.model = model;
		Controller.messageQueue = queue;
		valves.add(new FireBubbleValve());
	}
	
	/**
	 * what happens in the game every loop
	 */
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
}
