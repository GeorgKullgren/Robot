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
	
	@Test
	public void testAssignCardToHand() {
		Hand hand = new Hand();
		Card card1 = new Card(Movement.Forward, 19);
		hand.addCard(card1);
		assertNotNull(hand.getCard(0));
	}
	
	@Test
	public void selectOneCardAndCheckIfSelected() {
		Hand hand = new Hand();
		Card card = new Card(Movement.Forward, 19);
		hand.addCard(card);
		hand.selectCard(0);
		assertTrue(hand.isCardSelected(0));
	}

	@Test
	public void testSwapCards() {
		Hand hand = new Hand();
		Card card0 = new Card(Movement.Forward, 19);
		Card card1 = new Card(Movement.TurnLeft, 15);
		hand.addCard(card0);
		hand.addCard(card1);

		hand.selectCard(0);
		hand.selectCard(1);
		
		assertTrue(hand.getCard(0).equals(card0));
		assertTrue(hand.getCard(1).equals(card1));
		hand.swapCards();
		assertTrue(hand.getCard(0).equals(card1));
	}
	
	@Test
	public void moveCardRight() {
		Hand hand = new Hand();
		Card card0 = new Card(Movement.Forward, 19);
		Card card1 = new Card(Movement.TurnLeft, 15);
		Card card2 = new Card(Movement.TurnRight, 23);
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);

		hand.selectCard(1);
		
		hand.moveSelectedCardsRight();
		assertTrue(hand.getCard(2).equals(card1));		
	}
}
