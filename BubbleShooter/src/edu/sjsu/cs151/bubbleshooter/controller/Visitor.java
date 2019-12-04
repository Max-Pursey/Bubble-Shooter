package edu.sjsu.cs151.bubbleshooter.controller;

import edu.sjsu.cs151.bubbleshooter.model.Bubble;

public interface Visitor {
	void visitBubble(Bubble bubble);
}
