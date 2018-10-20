package week2.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void booleanExpression() {
        assertFalse(Main.booleanExpression(false, false, false, false));
        assertFalse(Main.booleanExpression(true, true, true, true));
        assertTrue(Main.booleanExpression(false, false, true, true));
        assertTrue(Main.booleanExpression(true, true, false, false));
        assertFalse(Main.booleanExpression(true, true, true, true));
    }
}
