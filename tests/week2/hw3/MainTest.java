package week2.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void doubleExpression() {
        assertTrue(Main.doubleExpression(0.1, 0.2, 0.3));
        assertFalse(Main.doubleExpression(1, 1, 4));
    }
}