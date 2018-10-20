package week2.hw7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    void isPalindrome() {
        assertTrue(Main.isPalindrome("Madam, I'm Adam!"));
    }
}