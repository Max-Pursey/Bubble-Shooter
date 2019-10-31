package edu.sjsu.cs151.bubbleshooter.model;

public class CollisionVisitor implements Visitor {
	private Bubble testBubble;
	private Bubble collisionBubble;
	private static final double RADIUS_OF_A_BUBBLE = 0.5;
	
	public CollisionVisitor(Bubble bubbleToTest)
	{
		testBubble = bubbleToTest;
	}
	
	public Bubble getCollision()
	{
		return collisionBubble;
	}
	
	public void visitBubble(Bubble bubble)
	{
		if(bubble != null)
		{
			double heightDistance = bubble.y - testBubble.y;
			double lengthDistance = bubble.x - testBubble.y;
			double distance = Math.sqrt(heightDistance*heightDistance+lengthDistance*lengthDistance); //Pythagorean Theorem to find distance between 2 bubbles
			if(distance < RADIUS_OF_A_BUBBLE*2)
			{
				collisionBubble = bubble;
			}
		}
	}
}
