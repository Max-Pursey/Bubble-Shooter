package edu.sjsu.cs151.bubbleshooter.view;

import java.awt.event.*;
import edu.sjsu.cs151.bubbleshooter.controller.*;

public class FireBubbleListener implements MouseListener {
	public void mouseClicked(MouseEvent e) {
		try {
			Controller.messageQueue.put(new FireBubbleMessage());
		}
		catch(InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("test2");
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
