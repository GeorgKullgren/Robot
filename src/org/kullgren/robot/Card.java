package org.kullgren.robot;

public class Card {

	public void setType(Movement move) {
		cardType = move;
	}

	public Movement getType() {
		return cardType;
	}

	Movement cardType;
}
