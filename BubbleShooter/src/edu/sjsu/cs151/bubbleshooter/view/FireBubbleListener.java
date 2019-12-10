package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.event.*;
import edu.sjsu.cs151.bubbleshooter.controller.*;
/**
 * the listener for the firebubbleaction when you fire a bubble
 * @author maxpu
 *
 */
public class FireBubbleListener implements MouseListener {
	/**
	 * handles when the mouse is actually clicked
	 */
	public void mouseClicked(MouseEvent e) {
		try {
			Controller.messageQueue.put(new FireBubbleMessage());
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
