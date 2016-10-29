package week3.hw2;

import org.junit.Before;
import org.junit.Test;
import week3.hw2.ComplexNumber;

import static org.junit.Assert.*;

public class ComplexNumberTest {

    private ComplexNumber a, b, c;

    @Before
    public void setUp() {
        this.a = new ComplexNumber(1, 1);
        this.b = new ComplexNumber(1, 1);
        this.c = new ComplexNumber(2, 2);
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
        assertFalse(a.equals(c));
        assertFalse(b.equals(c));
        assertFalse(c.equals(a));
        assertFalse(c.equals(b));
    }

    @Test
    public void testHashCode() throws Exception {
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
        assertNotEquals(b.hashCode(), c.hashCode());
    }
}