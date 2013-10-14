package org.kullgren.robot;

import java.util.ArrayList;

public class Board {

	private int Rows;
	private int Columns;

	public Board(int rows, int columns)
	{
		Rows = rows;
		Columns = columns;
	}
	
	public ArrayList<BoardPosition> getRandomBoard() {
		ArrayList<BoardPosition> boardPosition = new ArrayList<BoardPosition>();
		for (int i=0; i<400; i++) {
			BoardPosition pos = new BoardPosition();
			pos.setBlockedDirection(Direction.None);
			boardPosition.add(pos);
		}
		boardPosition.get(25).setBlockedDirection(Direction.Down);
		boardPosition.get(45).setBlockedDirection(Direction.Up);
		boardPosition.get(26).setBlockedDirection(Direction.Down);
		boardPosition.get(46).setBlockedDirection(Direction.Up);
		return boardPosition;
	}
}
