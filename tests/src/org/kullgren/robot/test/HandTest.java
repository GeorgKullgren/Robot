package org.kullgren.robot.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kullgren.robot.Card;
import org.kullgren.robot.Hand;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class HandTest extends AndroidTestCase {

	@Test
	public void testGenerateRandomCards() {
		Hand hand = new Hand();
		hand.generateRandomCards(5);
	}

	@Test
	public void testGetLastGeneratedCard() {
		Hand hand = new Hand();
		hand.generateRandomCards(5);

		assertNotNull(hand.getCard(4));
	}
	
	@Test
	public void testGetNonExistantCardReturnsNull() {
		Hand hand = new Hand();
		hand.generateRandomCards(5);

		assertNull(hand.getCard(5));		
	}
	
	public void testAssignCardToHand() {
		Hand hand = new Hand();
		Card card1 = new Card(Movement.Forward, 19);
		hand.addCard(card1);
	}
}
