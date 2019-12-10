package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Bubble;
/**
 * base interface used by all other visitor classes
 * @author maxpu
 *
 */
public interface Visitor {
	void visitBubble(Bubble bubble);
}
