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
	 private int score;
	 
	 public GameInfo()
	 {
		 Board.getInstance();
		boardInfo = Board.board;
		 Board.getInstance();
		ammoInfo = Board.ammo;
		 dx = 0;
		 dy = 0;
		 score = Model.score;
	 }
	 
	 public void updateBoard()
	 {
		 Board.getInstance();
		boardInfo = Board.board;
	 }
	 
	 public void updateAmmo()
	 {
		 Board.getInstance();
		ammoInfo = Board.ammo;
	 }
	 
	 public void updateCoordinates(double newdx, double newdy)
	 {
		 dx = newdx;
		 dy = newdy;
	 }
	 
	 public void updateScore()
	 {
		 score = Model.score;
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
	 
	 public int getScore()
	 {
		 return score;
	 }
}
