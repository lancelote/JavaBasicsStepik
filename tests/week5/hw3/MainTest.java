package week5.hw3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void readAsString() throws IOException {
        ByteArrayInputStream array = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        assertEquals("0123", Main.readAsString(array, StandardCharsets.US_ASCII));
    }
}