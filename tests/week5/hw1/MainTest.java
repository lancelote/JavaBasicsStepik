package week5.hw1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void checkSumOfStream() throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01});
        assertEquals(71, Main.checkSumOfStream(stream));
    }
}