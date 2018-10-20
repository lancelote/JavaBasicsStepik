package week2.hw8;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void factorial() {
        assertEquals(BigInteger.valueOf(1), Main.factorial(1));
        assertEquals(BigInteger.valueOf(6), Main.factorial(3));
    }

}