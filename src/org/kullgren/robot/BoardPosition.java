package org.kullgren.robot;

public class BoardPosition {
	private boolean[] blockedDirection;
	private int numBlockedDirections;
	private boolean hole;
	
	public BoardPosition() {
		blockedDirection = new boolean[4];
		blockedDirection[0] = false;
		blockedDirection[1] = false;
		blockedDirection[2] = false;
		blockedDirection[3] = false;
		numBlockedDirections = 0;
	}
	
	public void createHole() {
		hole = true;
	}
	
	public boolean isHole() {
		return hole;
	}
	
	public void setBlockedDirection(Direction direction) {
		blockedDirection[direction.ordinal()] = true;
		++numBlockedDirections;
	}
	
	public boolean isBlocked(Direction direction)
	{
		return blockedDirection[direction.ordinal()];
	}
	
	public int getNumBlockedDirections() {
		return numBlockedDirections;
	}
}
