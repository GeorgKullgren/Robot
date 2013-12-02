package org.kullgren.robot.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kullgren.robot.Board;
import org.kullgren.robot.Direction;
import org.kullgren.robot.Robot;

import android.test.AndroidTestCase;

public class BoardTest extends AndroidTestCase {

    @Override
    @Before
    public void setUp() {
        board = new Board(20, 20);
    }
    
    @Test
    public void testCreateBoardAndGetLastPosition() {
        assertNotNull(board);
        assertNotNull(board.get(19,19));
    }

    @Test
    public void testCreateRandomBoard () {
        board.createRandomBoard();
        assertNotNull(board.get(19,19));        
    }
    
    @Test
    public void testAddRobotToBoard() {
        Robot robot = new Robot();
        board.addRobot(robot, 0);
        assertTrue(board.getRobot().equals(robot));
    }
    
    @Test
    public void testMoveRobotUp() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 9, 19);
        int newPosition = board.moveRobot(Direction.Up);
        
        assertEquals(originalPosition-20, newPosition);
    }
    
    @Test
    public void testMoveRobotDown() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 9, 15);
        int newPosition = board.moveRobot(Direction.Down);
        
        assertEquals(originalPosition+20, newPosition);
    }
    
    @Test
    public void testMoveRobotLeft() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 9, 19);
        int newPosition = board.moveRobot(Direction.Left);
        
        assertEquals(originalPosition-1, newPosition);
    }
    
    @Test
    public void testMoveRobotRight() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 9, 19);
        int newPosition = board.moveRobot(Direction.Right);
        
        assertEquals(originalPosition+1, newPosition);
    }
    
    @Test
    public void testMoveRobotLeftOffBoardReturnsSamePosition() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 0, 9);
        int newPosition = board.moveRobot(Direction.Left);
        
        assertEquals(originalPosition, newPosition);
    }
    
    @Test
    public void testMoveRobotRightOffBoardReturnsSamePosition() {
        Robot robot = new Robot();
        int originalPosition = board.addRobot(robot, 19, 9);
        int newPosition = board.moveRobot(Direction.Right);
        
        assertEquals(originalPosition, newPosition);
    }
    
    
    
    Board board;
}
