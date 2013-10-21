package org.kullgren.robot;

import java.util.ArrayList;

public class Board {

	private int Rows;
	private int Columns;
	private int numPositions;
	
	private ArrayList<BoardPosition> board;

	public Board(int rows, int columns)
	{
		Rows = rows;
		Columns = columns;
		numPositions = rows*columns;
	}
	
	public BoardPosition get(int position)
	{
		return board.get(position);
	}
	
	private void setBlockedDirection(int x, int y, Direction direction) {
		int position = y*Columns+x;
		setBlockedDirection(position, direction);
	}
	
	private void setBlockedDirection(int position, Direction direction)
	{
		board.get(position).setBlockedDirection(direction);
		if (direction.equals(Direction.Left) && position > 0) {
			board.get(position-1).setBlockedDirection(Direction.Right);
		}
		if (direction.equals(Direction.Right) && position < numPositions-1) {
			board.get(position+1).setBlockedDirection(Direction.Left);
		}
		if (direction.equals(Direction.Up) && position > Columns-1) {
			board.get(position-Columns).setBlockedDirection(Direction.Down);
		}
		if (direction.equals(Direction.Down) && position < numPositions-Columns) {
			board.get(position+Columns).setBlockedDirection(Direction.Up);
		}
	}
	
	public void createRandomBoard() {
		board = new ArrayList<BoardPosition>();
		for (int i=0; i<Rows*Columns; i++) {
			BoardPosition pos = new BoardPosition();
			board.add(pos);
		}
		setBlockedDirection(2, 7, Direction.Down);
		setBlockedDirection(3, 7, Direction.Down);
		setBlockedDirection(3, 7, Direction.Right);
		setBlockedDirection(3, 6, Direction.Right);
		setBlockedDirection(5, 2, Direction.Down);
		setBlockedDirection(6, 2, Direction.Down);
		setBlockedDirection(6, 2, Direction.Right);
		setBlockedDirection(6, 3, Direction.Right);
		setBlockedDirection(9, 4, Direction.Right);
		setBlockedDirection(9, 5, Direction.Right);
		setBlockedDirection(13, 3, Direction.Left);
		setBlockedDirection(13, 2, Direction.Left);
		setBlockedDirection(13, 2, Direction.Down);		
		setBlockedDirection(14, 2, Direction.Down);
		setBlockedDirection(17, 7, Direction.Down);
		setBlockedDirection(16, 7, Direction.Down);
		setBlockedDirection(16, 7, Direction.Left);
		setBlockedDirection(16, 6, Direction.Left);
	}
}
