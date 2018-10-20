package week2.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void charExpression() {
        assertEquals('|', Main.charExpression(32));
        assertEquals('y', Main.charExpression(29));
    }
}