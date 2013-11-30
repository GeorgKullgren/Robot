package org.kullgren.robot;

import org.kullgren.robot.Board;

public class RobotHandler {
    Board myBoard;

    public RobotHandler(Board board) {
        myBoard = board;
    }

    public int addRobot(Robot robot, int i, int j) {
        return myBoard.addRobot(robot, i, j);
    }

    public int moveRobot(Direction movement) {
        switch (movement) {
        case Down:
            break;
        case Up:
            break;
        case Right:
            break;
        case Left:
            break;
        default:
            break;
        }
        return myBoard.moveRobot(movement);
    }

}
