package edu.sjsu.cs151.bubbleshooter.game;

import java.util.concurrent.*;

import edu.sjsu.cs151.bubbleshooter.controller.*;
import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.*;

public class Game {
	
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;

	
	public static void main(String[] args) {
		view = View.init(queue);
		model = new Model();
		Controller game = new Controller(view, model, queue);
		game.mainLoop();
		view.dispose();
		queue.clear();
	}
}
