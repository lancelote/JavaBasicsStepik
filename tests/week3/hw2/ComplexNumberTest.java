package week3.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ComplexNumberTest {

    private ComplexNumber a, b, c;

    @BeforeEach
    void setUp() {
        this.a = new ComplexNumber(1, 1);
        this.b = new ComplexNumber(1, 1);
        this.c = new ComplexNumber(2, 2);
    }

    @Test
    void testEquals() {
        assertEquals(a, b);
        assertEquals(b, a);
        assertNotEquals(a, c);
        assertNotEquals(b, c);
        assertNotEquals(c, a);
        assertNotEquals(c, b);
    }

    @Test
    void testHashCode() {
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
        assertNotEquals(b.hashCode(), c.hashCode());
    }
}