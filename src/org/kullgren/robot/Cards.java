package org.kullgren.robot;

import java.util.ArrayList;
import java.util.List;

public class Cards {
	
	public Cards() {
	}

	private int findFirstFreePosition() {
		int position = 0;
		while (position < numberOfCards  && cards[position] != null) {
			++position;
		}
		return position;
	}

	private int findFirstCard() {
		int position = 0;
		while (position < numberOfCards && cards[position] == null) {
			++position;
		}
		return position;
	}

	public boolean addCard(Card card) {
		int position = findFirstFreePosition();
		
		if (position < numberOfCards) {
			cards[position] = card;
			return true;
		}
		
		return false;
	}

	public Card getNextCard() {
		int position = findFirstCard();
		
		if (position < numberOfCards) {
			Card card = cards[position];
			cards[position] = null;
			return card;
		}
		return null;
	}
	
	public void putCard(Card card, int position) {
		if (position < numberOfCards) {
			cards[position] = card;
		}
	}

	public void setSize(int size) {
		cards = new Card[size];
		numberOfCards = size;
	}
	
	Card cards[];
	int numberOfCards;


}
