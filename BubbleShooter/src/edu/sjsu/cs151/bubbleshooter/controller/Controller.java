package edu.sjsu.cs151.bubbleshooter.controller;

import java.util.*;
import java.util.concurrent.*;
import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.View;



public class Controller {
	
	private BlockingQueue<Message> messageQueue;
	private View view;
	private Model model;
	private Board gameinfo;
	List<Valve> valves = new LinkedList<Valve>();
	
	
	public Controller(View view, Model model, BlockingQueue<Message> queue) {
		this.view = view;
		this.model = model;
		this.messageQueue = queue;
	}
	
	
	public void mainLoop() {
		
	}
	
	public void updateGameInfo() {
		
	}
}
