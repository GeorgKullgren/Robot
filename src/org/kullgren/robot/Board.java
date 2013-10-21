package org.kullgren.robot;

import java.util.ArrayList;

public class Board {

	private int Rows;
	private int Columns;
	private ArrayList<BoardPosition> board;

	public Board(int rows, int columns)
	{
		Rows = rows;
		Columns = columns;
	}
	
	public BoardPosition get(int position)
	{
		return board.get(position);
	}
	
	public void createRandomBoard() {
		board = new ArrayList<BoardPosition>();
		for (int i=0; i<Rows*Columns; i++) {
			BoardPosition pos = new BoardPosition();
			board.add(pos);
		}
		board.get(25).setBlockedDirection(Direction.Down);
		board.get(45).setBlockedDirection(Direction.Up);
		board.get(26).setBlockedDirection(Direction.Down);
		board.get(46).setBlockedDirection(Direction.Up);
		board.get(46).setBlockedDirection(Direction.Right);
		board.get(47).setBlockedDirection(Direction.Left);
	}
}
