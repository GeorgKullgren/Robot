package org.kullgren.robot.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kullgren.robot.Board;
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
    Board board;
}
