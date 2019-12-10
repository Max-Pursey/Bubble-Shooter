package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;
/**
 * handles the generic shape of bubbles
 * @author maxpu
 *
 */
public class ShapeIcon implements Icon
{
	/**
	 * constructs a ShapeIcon object
	 * @param shapes
	 * @param width
	 * @param height
	 */
   public ShapeIcon(BubbleShape[] shapes,
      int width, int height)
   {
      this.shapes = shapes;
      this.width = width;
      this.height = height;
   }
   /**
    * returns the width of an icon
    * @return width
    */
   public int getIconWidth()
   {
      return width;
   }
   /**
    * returns the height of an icon
    * @return height
    */
   public int getIconHeight()
   {
      return height;
   }
   /**
    * returns the amount of bubbles shown
    * @return bubblesShown
    */
   public int getBubblesShown() 
   {
	   return bubblesShown;
   }
   /**
    * sets bubblesShown to the new amount of shown bubbles
    * @param shown
    */
   public void setBubblesShown(int shown)
   {
	   bubblesShown = shown;
   }
/**
 * paints all of the bubbles shown
 */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for(int i = 0; i < bubblesShown; i++)
    	  shapes[i].draw(g2);
   }

   private int width;
   private int height;
   private BubbleShape[] shapes;
   public static int bubblesShown = 0;
}