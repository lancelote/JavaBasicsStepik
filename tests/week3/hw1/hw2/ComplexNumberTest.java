package week3.hw1.hw2;

import org.junit.Before;
import org.junit.Test;

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
    public void equals() throws Exception {
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertNotEquals(b, c);
    }

    @Test
    public int hashCode() throws Exception {

    }
}