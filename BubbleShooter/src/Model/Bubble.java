package Model;

import java.awt.Color;

public class Bubble 
{
	private Bubble left;
	private Bubble right;
	private Bubble topLeft;
	private Bubble topRight;
	private Bubble bottomLeft;
	private Bubble bottomRight;
	private Color color;
	
	public Bubble(Bubble thisLeft, Bubble thisRight, Bubble thisTopLeft, Bubble thisTopRight, Bubble thisBottomLeft, 
	Bubble thisBottomRight, Color thisColor)
	{
		left = thisLeft;
		if (thisLeft != null) {
			thisLeft.right = this;
		}
		right = thisRight;
		if (thisRight != null) {
			thisRight.left = this;
		}
		topLeft = thisTopLeft;
		if (thisTopLeft != null) {
			thisTopLeft.bottomRight = this;
		}
		topRight = thisTopRight;
		if (thisTopRight != null) {
			thisTopRight.bottomLeft = this;
		}
		bottomLeft = thisBottomLeft;
		if (thisBottomLeft != null) {
			thisBottomLeft.topRight = this;
		}
		bottomRight = thisBottomRight;
		if (thisBottomRight != null) {
			thisBottomRight.topLeft = this;
		}
		color = thisColor;
	}
	
	/**
	 * This method returns the left node of this Bubble.
	 * @return left
	 */
	public Bubble getLeft()
	{
		return left;
	}
	
	/**
	 * This returns the right node of this Bubble.
	 * @return right
	 */
	public Bubble getRight()
	{
		return right;
	}
	
	/**
	 * This returns the top left node of this Bubble.
	 * @return topLeft
	 */
	public Bubble getTopLeft()
	{
		return topLeft;
	}
	
	/**
	 * This returns the top right node of this Bubble.
	 * @return topRight
	 */
	public Bubble getTopRight()
	{
		return topRight;
	}
	
	/**
	 * This returns the bottom left node of this Bubble.
	 * @return bottomLeft
	 */
	public Bubble getBottomLeft()
	{
		return bottomLeft;
	}
	
	/**
	 * This returns the bottom right node of this Bubble.
	 * @return bottomRight
	 */
	public Bubble getBottomRight()
	{
		return bottomRight;
	}
	
	/**
	 * This returns the color of the bubble.
	 * @return color
	 */
	public Color getColor()
	{
		return color;
	}
}
