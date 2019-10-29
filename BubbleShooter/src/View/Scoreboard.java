package View;

/**
 * A class that controls and displays the Score.
 */

public class Scoreboard {
	
private int score;
	
	/**
	 * Constructs a Scoreboard object that sets the score to 0.
	 * @postcondition score is 0.
	 */
	public Scoreboard() {
		score = 0;
	}
	
	/**
	 * method that increases the Scoreboard score
	 * @param increment the amount to increase the score by.
	 * 
	 */
	public void increaseScore(int increment) {
		score += increment;
	}
	
	/**
	 * method that returns the score
	 * @return score the score of the Scoreboard
	 */
	public int getScore() {
		return score;
	}
}

