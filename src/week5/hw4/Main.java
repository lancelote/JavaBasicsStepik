package week5.hw4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        while (scanner.hasNext()) {
            try {
                result += Double.parseDouble(scanner.next());
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.format("%.6f", result);
    }
}
