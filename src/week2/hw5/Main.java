package week2.hw5;

/**
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш)
 * на расстоянии a.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(charExpression(32));  // |
        System.out.println(charExpression(29));  // y
    }

    private static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
