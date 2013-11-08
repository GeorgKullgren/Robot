package org.kullgren.robot;

import org.kullgren.robot.Board;

public class RobotHandler {
    Board myBoard;
    Coordinate myPosition;

    public RobotHandler(Board board) {
        myBoard = board;
    }

    public void addRobot(Robot robot, int i, int j) {
        myBoard.addRobot(robot, i, j);
    }

    public Coordinate moveRobot(Direction up) {
        return new Coordinate(1, 1);
    }

}
