package edu.sjsu.cs151.bubbleshooter.controller;

import java.util.ArrayList;

import edu.sjsu.cs151.bubbleshooter.model.*;
import edu.sjsu.cs151.bubbleshooter.view.*;
/**
 * a class to keep track of important game info
 * @author maxpu
 *
 */
public class GameInfo 
{
	 private Bubble[][] boardInfo;
	 private ArrayList<Bubble> ammoInfo;
	 private double dx;
	 private double dy;
	 private int score;
	 /**
	  * creates an object containing all important game info.
	  */
	 public GameInfo()
	 {
		boardInfo = Board.board;
		ammoInfo = Board.ammo;
		 dx = 0;
		 dy = 0;
		 score = Model.score;
	 }
	 /**
	  * updates the board info.
	  */
	 public void updateBoard()
	 {
		boardInfo = Board.board;
	 }
	 /**
	  * updates the ammo info.
	  */
	 public void updateAmmo()
	 {
		ammoInfo = Board.ammo;
	 }
	 /**
	  * updates the coordinates of a bubble moving
	  * @param newdx
	  * @param newdy
	  */
	 public void updateCoordinates(double newdx, double newdy)
	 {
		 dx = newdx;
		 dy = newdy;
	 }
	 /**
	  * updates the current score
	  */
	 public void updateScore()
	 {
		 score = Model.score;
	 }
	 /**
	  * returns the 2d array containing every bubble on the board
	  * @return boardInfo
	  */
	 public Bubble[][] getBoardInfo()
	 {
		 return boardInfo;
	 }
	 /**
	  * returns info on the ammo
	  * @return ammoInfo
	  */
	 public ArrayList<Bubble> getAmmo()
	 {
		 return ammoInfo;
	 }
	 /**
	  * returns info on dx
	  * @return dx
	  */
	 public double getdx()
	 {
		 return dx;
	 }
	 /**
	  * returns info on dy
	  * @return dy
	  */
	 public double getdy()
	 {
		 return dy;
	 }
	 /**
	  * returns info on score
	  * @return score
	  */
	 public int getScore()
	 {
		 return score;
	 }
}
