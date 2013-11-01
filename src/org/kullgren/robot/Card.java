package org.kullgren.robot;

public class Card {

	public Card() {}
	
	public Card(Movement move, int pri) {
		cardType = move;
		priority = pri;
		isInvalid = false;
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

	public void toggleInvalid() {
		if (isInvalid) {
			isInvalid = false;
		}
		else {
			isInvalid = true;
		}
	}
	
	Movement cardType;
	int priority;
	boolean isInvalid;
	public boolean isCardInvalid() {
		return isInvalid;
	}
}
