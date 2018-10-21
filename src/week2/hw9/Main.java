package week2.hw9;

/**
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке
 * массив. Массивы могут быть любой длины, в том числе нулевой.
 *
 * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным
 * массивам и сразу формировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива
 * при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически это не проверить, так что это остается
 * на вашей совести :)
 */
public class Main {
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0;

        while (i < a1.length && j < a2.length)
            if (a1[i] < a2[j])
                result[i+j] = a1[i++];
            else
                result[i+j] = a2[j++];

        while (i < a1.length)
            result[i+j] = a1[i++];

        while (j < a2.length)
            result[i+j] = a2[j++];
        return result;
    }
}
