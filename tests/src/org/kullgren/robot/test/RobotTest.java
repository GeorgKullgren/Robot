package org.kullgren.robot.test;

import org.junit.Before;
import org.junit.Test;
import org.kullgren.robot.Robot;
import org.kullgren.robot.Movement;

import android.test.AndroidTestCase;

public class RobotTest extends AndroidTestCase {

    @Test
    void testCreateRobot() {
        Robot myRobot = new Robot();
        assertNotNull(myRobot);
    }
}
