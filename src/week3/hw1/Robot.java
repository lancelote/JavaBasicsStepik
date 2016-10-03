package week3.hw1;

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
        return Direction.UP;
    }

    public int getX() {
        // текущая координата X
        return 0;
    }

    public int getY() {
        // текущая координата Y
        return 0;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
