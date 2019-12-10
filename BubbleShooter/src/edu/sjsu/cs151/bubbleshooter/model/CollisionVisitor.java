package edu.sjsu.cs151.bubbleshooter.model;

import edu.sjsu.cs151.bubbleshooter.controller.Visitor;
/**
 * can visit a bubble and check if it collides with another bubble
 * @author maxpu
 *
 */
public class CollisionVisitor implements Visitor {
	private Bubble testBubble;
	private Bubble collisionBubble;
	private static final double RADIUS_OF_A_BUBBLE = 0.5;
	/**
	 * creates a CollisionVisitor object
	 * @param bubbleToTest
	 */
	public CollisionVisitor(Bubble bubbleToTest)
	{
		testBubble = bubbleToTest;
	}
	/**
	 * returns the bubble that the visitor has collided with
	 * @return collisionBubble
	 */
	public Bubble getCollision()
	{
		return collisionBubble;
	}
	/**
	 * checks if the visitor is colliding with the bubble
	 * @param bubble
	 */
	public void visitBubble(Bubble bubble)
	{
		if(bubble != null)
		{
			double heightDistance = bubble.y - testBubble.y;
			double lengthDistance = bubble.x - testBubble.x;
			double distance = Math.sqrt((heightDistance*heightDistance)+(lengthDistance*lengthDistance)); //Pythagorean Theorem to find distance between 2 bubbles
			if(distance < RADIUS_OF_A_BUBBLE*2)
			{
				collisionBubble = bubble;
			}
		}
	}
}
