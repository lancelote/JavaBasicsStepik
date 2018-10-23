package week4.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void sqrt() {
        assertEquals(0, Main.sqrt(0));
        assertEquals(1, Main.sqrt(1));
        assertEquals(2, Main.sqrt(4));
    }

    @Test
    void sqrtThrows() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Main.sqrt(-1));
        assertEquals("Expected non-negative number, got -1.0", exception.getMessage());
    }
}