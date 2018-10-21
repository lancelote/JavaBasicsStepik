package week3.hw5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    private TextAnalyzer[] analyzers;

    @BeforeEach
    void setUp() {
        TextAnalyzer spam = new SpamAnalyzer(new String[]{"spam"});
        TextAnalyzer negative = new NegativeTextAnalyzer();
        TextAnalyzer tooLong = new TooLongTextAnalyzer(9);

        this.analyzers = new TextAnalyzer[]{spam, negative, tooLong};
    }

    @Test
    void testSpam() {
        assertEquals(Label.SPAM, new Main().checkLabels(analyzers, "spam"));
    }

    @Test
    void testNegative() {
        assertEquals(Label.NEGATIVE_TEXT, new Main().checkLabels(analyzers, ":("));
    }

    @Test
    void testTooLong() {
        assertEquals(Label.TOO_LONG, new Main().checkLabels(analyzers, "01234567890"));
    }

    @Test
    void allOk() {
        assertEquals(Label.OK, new Main().checkLabels(analyzers, "hello"));
    }
}