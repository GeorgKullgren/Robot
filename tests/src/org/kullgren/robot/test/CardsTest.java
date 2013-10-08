package org.kullgren.robot.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kullgren.robot.Card;
import org.kullgren.robot.Cards;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class CardsTest extends AndroidTestCase {

	@Test
	public void test_insert_card_in_list() {
		Card firstCard = new Card();
		firstCard.setType(Movement.TurnLeft);
		
		Cards cards = new Cards();
		cards.setSize(1);
		assertNotNull(cards.addCard(firstCard));
	}
	
	@Test
	public void test_get_first_card() {
		Card firstCard = new Card();
		Card secondCard = new Card();
		firstCard.setType(Movement.TurnLeft);
		secondCard.setType(Movement.TurnRight);
		
		Cards cards = new Cards();
		cards.setSize(2);
		assertNotNull(cards.addCard(firstCard));
		assertNotNull(cards.addCard(secondCard));
		assertEquals(cards.getNextCard(), firstCard);
	}
	
	@Test
	public void test_add_four_cards_and_get_them_in_order() {
		Card firstCard = new Card();
		Card secondCard = new Card();
		Card thirdCard = new Card();
		Card fourthCard = new Card();
		firstCard.setType(Movement.TurnLeft);
		secondCard.setType(Movement.TurnRight);
		thirdCard.setType(Movement.Forward);
		fourthCard.setType(Movement.Wait);
		
		Cards cards = new Cards();
		cards.setSize(4);
		assertNotNull(cards.addCard(firstCard));
		assertNotNull(cards.addCard(secondCard));
		assertNotNull(cards.addCard(thirdCard));
		assertNotNull(cards.addCard(fourthCard));
		assertEquals(cards.getNextCard(), firstCard);
		assertEquals(cards.getNextCard(), secondCard);
		assertEquals(cards.getNextCard(), thirdCard);
		assertEquals(cards.getNextCard(), fourthCard);
		assertNull(cards.getNextCard());
	}
	
	@Test
	public void test_replace_middle_card() {
		Card firstCard = new Card(Movement.TurnLeft, 1);
		Card secondCard = new Card(Movement.TurnRight, 2);
		Card thirdCard = new Card(Movement.Forward, 3);
		
		Cards cards = new Cards();
		cards.setSize(3);
		cards.addCard(firstCard);
		cards.addCard(secondCard);
		cards.addCard(thirdCard);
		
		Card newCard = new Card(Movement.Wait, 4);
		cards.putCard(newCard, 1);
		
		assertEquals(cards.getNextCard().getPriority(), 1);
		assertEquals(cards.getNextCard().getPriority(), 4);
		assertEquals(cards.getNextCard().getPriority(), 3);
		assertNull(cards.getNextCard());		
	}
	
	@Test
	public void test_put_card_in_preallocated_list() {
		Card card = new Card();
		card.setType(Movement.TurnLeft);
		
		Cards cards = new Cards();
		cards.setSize(5);
		cards.putCard(card, 2);
		
	}
}
