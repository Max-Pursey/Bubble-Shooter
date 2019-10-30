package Model;

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
		run();
	}
	
	/**
	 * The main running part of the program that controls the game
	 * and its user 
	 */
	public static void run() {
		
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
	public void pop(Arraylist<Bubble> pop) {
	}
	
	/**
	 *  Paint components of the board 
	 *  @param g the Graphics2D object
	 */
}
