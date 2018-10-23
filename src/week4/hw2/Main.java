package week4.hw2;

/**
 * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 * <p>
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный
 * утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName()
 * является точкой входа в программу, т.е. его никто не вызывал.
 * <p>
 * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
 * откуда сообщение было залогировано.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());  // null
        test();
    }

    public static void test() {
        System.out.println(getCallerClassAndMethodName());  // week4.hw2.Main#main
    }

    @SuppressWarnings("WeakerAccess")
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length < 4) {
            return null;  // is entry point
        }
        StackTraceElement element = stackTraceElements[3];
        String className = element.getClassName();
        String methodName = element.getMethodName();
        return className + "#" + methodName;
    }
}
