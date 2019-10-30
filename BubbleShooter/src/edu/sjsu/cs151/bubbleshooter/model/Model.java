package edu.sjsu.cs151.bubbleshooter.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * A class for running the program
 */

public class Model extends JFrame {

	/**
	 * Main method that runs the game
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.print("Enter any key to create a board: ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		System.out.println("\n\n");
		scan.close();
		run();
		/*
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 17; j++) {
				Bubble a = new Bubble(null, null, null, null, null, null);
				System.out.print(a.toString() + "  ");
			}
			System.out.println("");
			if(i%2 == 0)
				System.out.print("   ");
		}
		Bubble a = new Bubble(null, null, null, null, null, null);
		System.out.println("\n\n\n\n\t\t\t\t\t\t\t\t" + a.toString());		
		*/
	}
	
	/**
	 * The main running part of the program that controls the game
	 * and its user 
	 */
	public static void run() {
		
		// doesn't work because of bug in board at line 21: out of bounds -1. i think you need to add another corner case for top row that dont have any bubbles above.
		Bubble[][] bubbles = Board.getInstance().getBoardBubbles();
		for(int i = 0; i < bubbles.length; i++) {
			for(int j = 0; j < bubbles[0].length; j++) {
				System.out.print(bubbles[i][j].toString() + "  ");
			}
			System.out.println("");
			if(i%2 == 0)
				System.out.print("   ");
		}
	}
	
	public static ArrayList<Bubble> checkCombinations(Bubble source) {
		Color c = source.getColor();
		source.flipMarked();
		ArrayList<Bubble> combination = new ArrayList<>();
		
		if(c == source.getLeft().getColor() && !source.getLeft().getMarked())
			combination.addAll(checkCombinations(source.getLeft()));
		
		if(c == source.getRight().getColor() && !source.getRight().getMarked())
			combination.addAll(checkCombinations(source.getRight()));
		
		if(c == source.getTopLeft().getColor() && !source.getTopLeft().getMarked())
			combination.addAll(checkCombinations(source.getTopLeft()));
		
		if(c == source.getTopRight().getColor() && !source.getTopRight().getMarked())
			combination.addAll(checkCombinations(source.getTopRight()));
		
		if(c == source.getBottomLeft().getColor() && !source.getBottomLeft().getMarked())
			combination.addAll(checkCombinations(source.getBottomLeft()));
		
		if(c == source.getBottomRight().getColor() && !source.getBottomRight().getMarked())
			combination.addAll(checkCombinations(source.getBottomRight()));
		
		return combination;
	}
	
	
	
	// if arraylist greater than 3 pop them and add to scoreboard
	public void pop(ArrayList<Bubble> pop) {
	}
	
	/**
	 *  Paint components of the board 
	 *  @param g the Graphics2D object
	 */
}
