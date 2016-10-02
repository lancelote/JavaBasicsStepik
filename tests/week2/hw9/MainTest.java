package week2.hw9;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void mergeArraysMix() throws Exception {
        assertArrayEquals(Main.mergeArrays(new int[] {0, 2, 2}, new int[] {1, 3}), new int[] {0, 1, 2, 2, 3});
    }

    @Test
    public void mergeArraySecondBigger() throws Exception {
        assertArrayEquals(Main.mergeArrays(new int[] {1, 2}, new int[] {3, 4}), new int[] {1, 2, 3, 4});
    }

    @Test
    public void mergeArrayFirstBigger() throws Exception {
        assertArrayEquals(Main.mergeArrays(new int[] {3, 4}, new int[] {1, 2}), new int[] {1, 2, 3, 4});
    }
}