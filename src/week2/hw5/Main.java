package week2.hw5;

/**
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш)
 * на расстоянии a.
 */
public class Main {
    static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
