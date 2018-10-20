package week2.hw1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainTest {
    @Test
    public void booleanExpression() {
        assertFalse(Main.booleanExpression(false, false, false, false));
        assertFalse(Main.booleanExpression(true, true, true, true));
        assertTrue(Main.booleanExpression(false, false, true, true));
        assertTrue(Main.booleanExpression(true, true, false, false));
        assertFalse(Main.booleanExpression(true, true, true, true));
    }
}
