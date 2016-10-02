package week2.hw8;

import java.math.BigInteger;

/**
 * Реализуйте метод, вычисляющий факториал заданного натурального числа.
 *
 * Факториал NN вычисляется как 1⋅2⋅...⋅N1⋅2⋅...⋅N.
 *
 * Поскольку это очень быстро растущая функция, то даже для небольших NN вместимости типов int и long очень скоро
 * не хватит. Поэтому будем использовать BigInteger.
 */
public class Main {
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    @SuppressWarnings("WeakerAccess")
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i < value + 1; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
