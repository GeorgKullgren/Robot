package org.kullgren.robot.test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.kullgren.robot.Card;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class CardTest extends AndroidTestCase {

//	Card card;
	
	@Before
	public void setUp() throws Exception
	{
//		card = new Card();
	}
	
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
