package week5.hw2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int next;
        int buffer = System.in.read();
        while (buffer != -1) {
            next = System.in.read();
            if (buffer != 13 || next != 10) {
                System.out.write(buffer);
            }
            buffer = next;
        }
        System.out.flush();
    }
}