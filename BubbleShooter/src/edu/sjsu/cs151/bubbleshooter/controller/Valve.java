package edu.sjsu.cs151.bubbleshooter.controller;
/**
 * base interface for other valve classes
 * @author maxpu
 *
 */
public interface Valve {
	public ValveResponse execute(Message message);
}
