package week4.hw3;

/**
 * Реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в заданную точку и
 * затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.
 */
public class Main {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean success = false;

        for (int i = 0; !success && i < 3; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                success = true;
            } catch (RobotConnectionException ignored) {
            }
        }

        if (!success) {
            throw new RobotConnectionException("Timeout: 3 attempts are failed.");
        }
    }
}
