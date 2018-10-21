package week3.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsciiCharSequenceTest {

    private AsciiCharSequence array;

    @BeforeEach
    void setUp() {
        this.array = new AsciiCharSequence("hello world".getBytes());
    }

    @Test
    void length() {
        assertEquals(11, array.length());
    }

    @Test
    void charAt() {
        assertEquals('e', array.charAt(1));
    }

    @Test
    void subSequence() {
        String expected = new AsciiCharSequence("world".getBytes()).toString();
        assertEquals(expected, array.subSequence(6, 11).toString());
    }

    @Test
    void toStringTest() {
        assertEquals("hello world", array.toString());
    }
}