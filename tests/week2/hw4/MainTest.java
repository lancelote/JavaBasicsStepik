package week2.hw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void flipBit() {
        assertEquals(1, Main.flipBit(0, 1));
    }
}