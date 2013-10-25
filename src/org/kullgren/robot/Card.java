package org.kullgren.robot;

public class Card {

	public Card() {}
	
	public Card(Movement move, int pri) {
		cardType = move;
		priority = pri;
		selectedFlag = false;
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

	public void setSelectedFlag() {
		selectedFlag = true;
	}

	public void clearSelectedFlag() {
		selectedFlag = false;
	}

	public boolean isSelected() {
		return selectedFlag;
	}

	public void toggleSelectedFlag() {
		if (selectedFlag) {
			selectedFlag = false;
		}
		else {
			selectedFlag = true;
		}
	}

	Movement cardType;
	int priority;
	boolean selectedFlag;
}
