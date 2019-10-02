package BubbleShooter;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class BubbleTest {

	@Test
	void testColor() {
		Bubble testBubble = new Bubble(null, null, null, null, null, null, Color.blue);
		Color color = testBubble.getColor();
		assert(color.equals(Color.blue));
	}

}
