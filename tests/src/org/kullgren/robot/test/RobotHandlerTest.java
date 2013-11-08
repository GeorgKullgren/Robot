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
        assertTrue(myBoard.getRobot(9, 19).equals(robot));
    }

    @Test
    public void testMoveRobotUp() {
        Robot robot = new Robot();
        myHandler.addRobot(robot, 9, 19);
        Coordinate coord = myHandler.moveRobot(Direction.Up);
        
        assertEquals(coord.getxCoordinate(), 9);
        assertEquals(coord.getyCoordinate(), 18);
    }
}
