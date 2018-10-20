package week2.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void leapYearCount() {
        assertEquals(0, Main.leapYearCount(1));
        assertEquals(1, Main.leapYearCount(4));
        assertEquals(24, Main.leapYearCount(100));
    }
}
