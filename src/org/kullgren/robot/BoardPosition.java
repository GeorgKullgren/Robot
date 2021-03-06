package org.kullgren.robot;

public class BoardPosition {
	private boolean[] blockedDirection;
	private int numBlockedDirections;
	private boolean hole;
	private Robot myRobot;
	
	public BoardPosition() {
		blockedDirection = new boolean[4];
		blockedDirection[0] = false;
		blockedDirection[1] = false;
		blockedDirection[2] = false;
		blockedDirection[3] = false;
		numBlockedDirections = 0;
		myRobot = null;
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
	
	public int numRobotsPresent() {
	    if (myRobot != null) {
	        return 1;
	    }
	    return 0;
	}
	
    public void addRobot(Robot robot) {
        myRobot = robot;
    }

    public Robot deleteRobot()
    {
        Robot tmpRobot = myRobot;
        myRobot = null;
        return tmpRobot;
    }

    public Robot getRobot() {
        return myRobot;
    }
}
