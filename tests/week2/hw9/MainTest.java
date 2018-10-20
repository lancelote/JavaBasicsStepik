package week2.hw9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainTest {
    @Test
    void mergeArraysMix() {
        assertArrayEquals(Main.mergeArrays(new int[] {0, 2, 2}, new int[] {1, 3}), new int[] {0, 1, 2, 2, 3});
    }

    @Test
    void mergeArraySecondBigger() {
        assertArrayEquals(Main.mergeArrays(new int[] {1, 2}, new int[] {3, 4}), new int[] {1, 2, 3, 4});
    }

    @Test
    void mergeArrayFirstBigger() {
        assertArrayEquals(Main.mergeArrays(new int[] {3, 4}, new int[] {1, 2}), new int[] {1, 2, 3, 4});
    }
}