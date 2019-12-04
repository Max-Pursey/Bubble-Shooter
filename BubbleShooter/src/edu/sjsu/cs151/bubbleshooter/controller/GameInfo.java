package edu.sjsu.cs151.bubbleshooter.controller;

import java.util.ArrayList;

import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.*;

public class GameInfo 
{
	 private Bubble[][] boardInfo;
	 private ArrayList<Bubble> ammoInfo;
	 private double dx;
	 private double dy;
	 
	 public GameInfo()
	 {
		 boardInfo = Board.getInstance().board;
		 ammoInfo = Board.getInstance().ammo;
		 dx = 0;
		 dy = 0;
	 }
	 
	 public void updateBoard()
	 {
		 boardInfo = Board.getInstance().board;
	 }
	 
	 public void updateAmmo()
	 {
		 ammoInfo = Board.getInstance().ammo;
	 }
	 
	 public void updateCoordinates(double newdx, double newdy)
	 {
		 dx = newdx;
		 dy = newdy;
	 }
	 
	 public Bubble[][] getBoardInfo()
	 {
		 return boardInfo;
	 }
	 
	 public ArrayList<Bubble> getAmmo()
	 {
		 return ammoInfo;
	 }
	 
	 public double getdx()
	 {
		 return dx;
	 }
	 
	 public double getdy()
	 {
		 return dy;
	 }
}
