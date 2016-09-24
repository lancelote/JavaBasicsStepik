package week2.hw3;

import static java.lang.Math.abs;

/**
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
 * Допустимая погрешность – 0.0001 (1E-4)
 *
 * Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(doubleExpression(0.1, 0.2, 0.3));  // true
        System.out.println(doubleExpression(1, 1, 4));  // false
    }

    private static boolean doubleExpression(double a, double b, double c) {
        return abs(a + b - c) <= 1e-4;
    }
}
