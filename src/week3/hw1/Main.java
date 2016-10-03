package week3.hw1;

/**
 * Приведи робота в указанную точку
 */
public class Main {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int diffX = toX - robot.getX();
        int diffY = toY - robot.getY();

        boolean goRight = diffX > 0;
        boolean goTop = diffY > 0;

        if (goRight)
            while (robot.getDirection() != Direction.RIGHT)
                robot.turnRight();
        else
            while (robot.getDirection() != Direction.LEFT)
                robot.turnLeft();
        while (robot.getX() != toX)
            robot.stepForward();

        if (goTop)
            while (robot.getDirection() != Direction.UP)
                robot.turnRight();
        else
            while (robot.getDirection() != Direction.DOWN)
                robot.turnLeft();
        while (robot.getY() != toY)
            robot.stepForward();
    }
}

