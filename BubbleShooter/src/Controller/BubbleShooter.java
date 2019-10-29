package Controller;

import Model.Bubble;

/**
 * A class for managing the shooting of the bubble
 */

public class BubbleShooter {
	
	private int ammoCount;
	Bubble[] ammo;

	/**
	 * Constructs a BubbleShooter object that controls the shooting mechanics
	 */
	public BubbleShooter() {
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
