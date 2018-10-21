package week3.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void integrate() {
        assertEquals(10, Main.integrate(x -> 1, 0, 10), 0.001);
    }
}