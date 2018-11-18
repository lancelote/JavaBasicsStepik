package week5.hw3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
 */
public class Main {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int buffer;
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();

        while ((buffer = reader.read()) != -1) {
            stringBuilder.append((char) buffer);
        }
        return stringBuilder.toString();
    }
}
