package org.kullgren.robot.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kullgren.robot.Board;
import org.kullgren.robot.Coordinate;
import org.kullgren.robot.Direction;
import org.kullgren.robot.Robot;
import org.kullgren.robot.RobotHandler;

import android.test.AndroidTestCase;

public class RobotHandlerTest extends AndroidTestCase {
    Board myBoard;
    RobotHandler myHandler;

    @Override
    @Before
    public void setUp() throws Exception {
        myBoard = new Board(20, 20);
        myBoard.createRandomBoard();
        myHandler = new RobotHandler(myBoard);
    }

    @Test
    public void testAddRobotToBoard() {
        Robot robot = new Robot();
        myHandler.addRobot(robot, 9, 19);
        assertTrue(myBoard.getRobot().equals(robot));
    }

    @Test
    public void testMoveRobotUp() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 9, 19);
        int newPosition = myHandler.moveRobot(Direction.Up);
        
        assertEquals(originalPosition-20, newPosition);
    }
    
    @Test
    public void testMoveRobotDown() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 9, 15);
        int newPosition = myHandler.moveRobot(Direction.Down);
        
        assertEquals(originalPosition+20, newPosition);
    }
    
    @Test
    public void testMoveRobotLeft() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 9, 19);
        int newPosition = myHandler.moveRobot(Direction.Left);
        
        assertEquals(originalPosition-1, newPosition);
    }
    
    @Test
    public void testMoveRobotRight() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 9, 19);
        int newPosition = myHandler.moveRobot(Direction.Right);
        
        assertEquals(originalPosition+1, newPosition);
    }
    
    @Test
    public void testMoveRobotLeftOffBoardReturnsSamePosition() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 0, 9);
        int newPosition = myHandler.moveRobot(Direction.Left);
        
        assertEquals(originalPosition, newPosition);
    }
    
    @Test
    public void testMoveRobotRightOffBoardReturnsSamePosition() {
        Robot robot = new Robot();
        int originalPosition = myHandler.addRobot(robot, 19, 9);
        int newPosition = myHandler.moveRobot(Direction.Right);
        
        assertEquals(originalPosition, newPosition);
    }
}
