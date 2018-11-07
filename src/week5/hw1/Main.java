package week5.hw1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
 * <p>
 * Контрольная сумма данных вычисляется по следующему алгоритму:
 * <p>
 * 1) Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
 * 2) Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
 * <p>
 * Cn+1=rotateLeft(Cn) xor bn+1
 * <p>
 * где Cn — контрольная сумма первых n байт данных
 * rotateLeft — циклический сдвиг бит числа на один бит влево
 * (чтобы не изобретать велосипед, используйте Integer.rotateLeft),
 * bn — n-ный байт данных.
 * <p>
 * Поскольку метод не открывал данный InputStream, то и закрывать его он не должен. Выброшенное из методов InputStream
 * исключение должно выбрасываться из метода.
 */
public class Main {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int buffer;
        int controlSum = 0;
        while ((buffer = inputStream.read()) != -1) {
            controlSum = Integer.rotateLeft(controlSum, 1) ^ buffer;
        }
        return controlSum;
    }
}
