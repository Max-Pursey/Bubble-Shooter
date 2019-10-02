package BubbleShooter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScoreboardTest {

	@Test
	void testNoIncreases() {
		Scoreboard testSb = new Scoreboard();
		assertEquals(0, testSb.getScore());
	}
	@Test
	void testOneIncrease() {
		Scoreboard testSb = new Scoreboard();
		testSb.increaseScore(5);
		assertEquals(5, testSb.getScore());
	}
	
	@Test
	void testMultipleIncreases() {
		Scoreboard testSb = new Scoreboard();
		testSb.increaseScore(10);
		testSb.increaseScore(10);
		testSb.increaseScore(20);
		testSb.increaseScore(40);
		assertEquals(80, testSb.getScore());
	}
}
