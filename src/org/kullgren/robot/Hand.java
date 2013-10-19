package org.kullgren.robot;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> myCards;
	private int size;

	public Hand() {
		myCards = new ArrayList<Card>();
	}

	public void generateRandomCards(int numberOfCards) {
		size = numberOfCards;
		Card card1 = new Card(Movement.Forward, 19);
		Card card2 = new Card(Movement.TurnLeft, 19);
		Card card3 = new Card(Movement.TurnRight, 19);
		Card card4 = new Card(Movement.Wait, 19);
		Card card5 = new Card(Movement.TurnLeft, 19);
		myCards.add(card1);
		myCards.add(card2);
		myCards.add(card3);
		myCards.add(card4);
		myCards.add(card5);
	}

	public int numCards() {
		// TODO Auto-generated method stub
		return 5;
	}

	public Card getCard(int position) {
		if (position >= size) {
			return null;
		}
		return myCards.get(position);
	}

	public void addCard(Card card) {
		myCards.add(card);
	}


}
