package week2.hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void isPowerOfTwo() {
        assertFalse(Main.isPowerOfTwo(0));
        assertTrue(Main.isPowerOfTwo(1));
        assertTrue(Main.isPowerOfTwo(-2));
    }
}