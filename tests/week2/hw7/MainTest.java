package week2.hw7;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void isPalindrome() throws Exception {
        assertTrue(Main.isPalindrome("Madam, I'm Adam!"));
    }
}