package week3.hw4;

/**
 * Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
 * (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
 * AsciiCharSequence будет занимать в два раза меньше памяти.
 *
 * Класс AsciiCharSequence должен:
 *
 *     - реализовывать интерфейс java.lang.CharSequence;
 *     - иметь конструктор, принимающий массив байт;
 *     - определять методы length(), charAt(), subSequence() и toString()
 *
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence
 * (JavaDoc или исходники).
 *
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
 * поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
 */
public class AsciiCharSequence implements CharSequence {

    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public int length() {
        return this.bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] bytes = new byte[length];
        System.arraycopy(this.bytes, start, bytes, 0, length);
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(this.bytes);
    }
}
