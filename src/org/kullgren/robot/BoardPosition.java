package org.kullgren.robot;

public class BoardPosition {
	private Direction blockedDirection;

	public void setBlockedDirection(Direction direction) {
		blockedDirection = direction;	
	}
	
	public Direction getBlockedDirection()
	{
		return blockedDirection;
	}
}
