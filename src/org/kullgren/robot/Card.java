package org.kullgren.robot;

public class Card {

	public Card() {}
	
	public Card(Movement move, int pri) {
		cardType = move;
		priority = pri;
	}
	
	public void setPriority(int value) {
		priority = value;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setType(Movement move) {
		cardType = move;
	}

	public Movement getType() {
		return cardType;
	}

	Movement cardType;
	int priority;
}
