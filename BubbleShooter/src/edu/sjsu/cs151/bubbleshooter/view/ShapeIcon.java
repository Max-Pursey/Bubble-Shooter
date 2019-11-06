package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

public class ShapeIcon implements Icon
{
   public ShapeIcon(BubbleShape[] shapes,
      int width, int height)
   {
      this.shapes = shapes;
      this.width = width;
      this.height = height;
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for(int i = 0; i < View.bubblesShown; i++)
    	  shapes[i].draw(g2);
   }

   private int width;
   private int height;
   private BubbleShape[] shapes;
}