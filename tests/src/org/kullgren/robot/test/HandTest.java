package org.kullgren.robot.test;

import org.junit.Before;
import org.junit.Test;
import org.kullgren.robot.Card;
import org.kullgren.robot.Hand;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class HandTest extends AndroidTestCase {

	@Override
	@Before
	public void setUp() throws Exception {
		hand = new Hand();		
		card0 = new Card(Movement.Forward, 19);
		card1 = new Card(Movement.TurnLeft, 15);
		card2 = new Card(Movement.TurnRight, 23);
	}
	
	@Test
	public void testGenerateRandomCards() {
		hand.generateRandomCards(5);
	}

	@Test
	public void testGetLastGeneratedCard() {
		hand.generateRandomCards(5);
		assertNotNull(hand.getCard(4));
	}
	
	@Test
	public void testGetNonExistantCardReturnsNull() {
		hand.generateRandomCards(5);
		assertNull(hand.getCard(5));		
	}
	
	@Test
	public void testAssignCardToHand() {
		hand.addCard(card1);
		assertNotNull(hand.getCard(0));
	}
	
	@Test
	public void selectOneCardAndCheckIfSelected() {
		hand.addCard(card1);
		hand.selectCard(0);
		assertTrue(hand.isCardSelected(0));
	}

	@Test
	public void testMoveCardRight() {
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);
		
		hand.selectCard(1);

		hand.moveSelectedCardsRight();
		assertTrue(hand.getCard(2).equals(card1));		
	}
	
	@Test
	public void testMoveCardLeft() {
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);

		hand.selectCard(1);

		hand.moveSelectedCardsLeft();
		assertTrue(hand.getCard(0).equals(card1));		
	}
	
	@Test
	public void testInvalidateCard() {
		hand.addCard(card0);

		hand.selectCard(0);
		hand.invalidateCard();
		
		assertTrue(hand.isCardInvalid(0));		
	}
	
	@Test
	public void testInvalidateFirstCardMovesCardToEndOfList() {
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);

		hand.selectCard(0);
		hand.invalidateCard();
		
		assertTrue(hand.getCard(2).equals(card0));
		assertTrue(hand.isCardInvalid(2));
	}
	
	@Test
	public void testInvalidateMiddleCardMovesCardToEndOfList() {
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);

		hand.selectCard(1);
		hand.invalidateCard();
		
		assertTrue(hand.getCard(2).equals(card1));
		assertTrue(hand.isCardInvalid(2));
	}
	
	@Test
	public void testInvalidateCardMovesCardAfterAllValidCards() {
		hand.addCard(card0);
		hand.addCard(card1);
		hand.addCard(card2);

		hand.selectCard(2);
		hand.selectCard(0);
		hand.invalidateCard();
		
		assertTrue(hand.getCard(0).equals(card1));
		assertFalse(hand.isCardInvalid(0));
		assertTrue(hand.isCardInvalid(1));
		assertTrue(hand.isCardInvalid(2));
	}
	
	
	Hand hand;
	Card card0;
	Card card1;
	Card card2;
}

