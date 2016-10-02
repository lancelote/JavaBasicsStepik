package week2.hw8;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void factorial() throws Exception {
        assertEquals(BigInteger.valueOf(1), Main.factorial(1));
        assertEquals(BigInteger.valueOf(6), Main.factorial(3));
    }

}