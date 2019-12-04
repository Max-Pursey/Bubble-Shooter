package edu.sjsu.cs151.bubbleshooter.model;

public class ModelTest 
{
	public static void main(String[] args)
	{
		Bubble[][] test = Board.getInstance().getBoardBubbles();
		Bubble collider = new Bubble(null,null,null,null,null,null);
		collider.x = 3;
		collider.y = 2.5;
		CollisionVisitor collisionVisitor = new CollisionVisitor(collider);
		Board.getInstance().visit(collisionVisitor);
		if(collisionVisitor.getCollision() != null)
		{
			System.out.println("Success!");
		}
		Model tester = new Model();
		tester.settleBubble(collider);
		System.out.println("Done!");
		tester.addRow();
		System.out.println("Done!");
		
	}
}
