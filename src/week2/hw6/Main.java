package week2.hw6;

/**
 * Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
 *
 * Решать можно разными способами:
 *
 * - воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
 * - применив пару трюков из двоичной арифметики;
 * - написав решение "в лоб" с циклом и условными операторами.
 */
public class Main {
    /**
     * Checks if a given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when a<code>value</code> is power of two, <code>false</code> otherwise
     */
    static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return value != 0 && (value & -value) == value;
    }
}
