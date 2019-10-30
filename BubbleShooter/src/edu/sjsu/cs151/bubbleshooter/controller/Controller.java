package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Bubble;

/**
 * A class for managing the shooting of the bubble
 */

public class Controller {
	
	private int ammoCount;
	Bubble[] ammo;

	/**
	 * Constructs a BubbleShooter object that controls the shooting mechanics
	 */
	public Controller() {
		ammoCount = 5;
		// initialize ammo bubbles
	}
	
	/**
	 * Calculates the bubble end location and paints the bubble animation
	 */
	public void shoot() {
		ammoCount--;
		if(ammoCount == 0) {
	
		}
	}
}
