package org.kullgren.robot.test;
import org.junit.Test;
import org.kullgren.robot.Card;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class CardTest extends AndroidTestCase {

	@Test
	public void test_create_card() {
		Card card = new Card();
		assertNotNull(card);
	}

	@Test
	public void test_set_card_type() {
		Card card = new Card();
		card.setType(Movement.Forward);
		assertEquals(card.getType(), Movement.Forward);
	}
}
