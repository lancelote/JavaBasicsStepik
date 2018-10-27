# 4. Обработка ошибок, исключения, отладка

## 4.1. Исключения

### Примеры работы с ошибками

```java
public interface Calculator {
    double calculate(String expr);
}
```

- Самый простой способ обработать ошибочное значение в методе - завершить исполнение с `System.exit(1)`
- Лучший способ возвращать специальное значение, например `Double.NAN`.
- Можно также завести поле под признак ошибки внутри класса

### Примеры исключений

```
Object nullRef = null;

// java.lang.NullPointerException
nullRef.toString();
```

```
int[] array = {1, 2, 3};

// java.lang.ArrayIndexOutOfBoundsException
array[10];
```

```
// java.io.FileNotFoundException
new FileInputStream("not_existing_file");
```

### `java.lang.Throwable`

Все исключения в Java наследуются от `java.lang.Throwable`

```
throw new IllegalStateException("Invalid user.");
```

### Методы `Throwable`

- `public String getMessage()` получить строку из конструктора исключения
- `public void printStackTrace()` печатает stacktrace в stderr
- `public StackTraceElement[] getStackTrace()` возвращает stacktrace в виде массива
- `public Throwable getCause()` - возвращает другое исключение, явившееся причиной данного или `null`, если данное исключение является первичным. Причина может быть задана при инициализации исключения
- `public Trowable[] getSuppressed()` - возвращает исключения, которые были заглушены в процессе обработки основного исключения

### Классификация исключений

- Исключительные ситуации в JVM - `java.lang.Error`
- Исключительные ситуации в пользовательском коде
    - Проверяемые (checked) - `java.lang.Exception`
    - Непроверяемые (unchecked) - `java.lang.RuntimeException`, наследует `java.lang.Exception`
    
#### `java.lang.Error`

- `java.lang.OutOfMemoryError`
- `java.lang.NoClassFoundError`
- `java.lang.VeirfyError`

#### `java.lang.Exception`

```java
import java.io.IOException;

public class ExceptionDemo {
    public void someMethod() throws IOException {
        throw new IOException("Failed to read file.");
    }
}
```

#### `java.lang.RuntimeException`

- `java.lang.NullPointerException`
- `java.lang.ArrayIndexOufOfBoundException`
- `java.lang.ArithmeticException`

### Собственное исключение

```java
public class CalculatorException extends RuntimeException {
    public CalculatorException(String message) {
        super(message);
    }
    
    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

## 4.2. Обработка исключений. Try-catch

### Базовый пример

```
for (;;) {
    System.out.print("Enter expression: ");
    String expression = readUserInput();
    if (expr == null || "exit".equalsIgnoreCase(expr)) {
        break;
    }
    try {
        double result = calculator.calculat(expr);
        System.out.println("Result: " + result);
    } catch (CalculatorException e) {
        System.out.print("Bad expression: " + e.getMessage());
        System.out.print("Please try again: ");
    }
}
```

### Перехват нескольких исключений

```
try {
    // ...
} catch (FirstException e) {
    e.printStackTrace();
} catch (SecondException e) {
    e.printStackTrace();
}
```

или в одном блоке `catch`

```
try {
    // ...
} catch (FirstException | SecondException e) {
    e.printStackTrace();
}
```

### Блок `finally`

```
InputStream is = new FileInputStream("a.txt");
try {
    readFromInputStream(is);
} finally {
    is.close();
}
```

`finally` обрабатывает всегда вне зависимости от вызванных исключений. Обычно предназначен для снятия блокировок, закрытия ресурсов.

В примере выше, если исключение будет брошено внутри `try` и внутри `finally`, то оригинальное исключение будет потеряно. Для решения этой проблемы используется следующий паттерн

```
InputStream is = new FileInputStream("a.txt");
try {
    readFromInputStream(is);
} finally {
    try {
        is.close();
    } catch (IOException e) {
        // ignore
    }
}
```

### `try` с ресурсами

```
try (InputStream is = new FileInputStream("a.txt")) {
    readFromInputStream(is);
}
```

- Несколько ресурсов перечисляется через `;`
- При выходе из блока все ресурсы будут освобождены (вызван метод `close()`)
- Исключение из `close()` не перебьет первое, а будет добавлено как заглушенное

#### Идея за реализацией `try` с ресурсами

```
InputStream is = new FileInputStream("a.txt");
try {
    readFromInputStream(is);
} catch (Throwable t) {
    try {
        is.close();
    } catch (Trhowable t2) {
        t.addSuppressed(t2);
    }
    throw t;
}
is.close();
```

#### Ресурс

**Ресурс** - любой объект реализующий `java.lang.AutoCloseable`.

```
package java.lang;

public static AutoClosable {
    void close() throws Exception;
}
```

### Обработка исключения

```
try {
    Double.parseDouble(...);
} catch (NumberFormatException e) {
    throw new CalculatorException(e);
}
```

Для простого логирования ошибки: `e.printStackTrace()`.

### Плохой пример

```
String string;
try {
    string = object.toString();
 } catch (NullPointerException e) {
    string = "null";
 }
 System.out.println(string);
```

### Хороший пример

```
String string = object == null ? "null" : object.toString();
System.out.println(string);
```

Можно также воспользоваться `Objects.toString(object)` из `java.util`, который реализует туже логику.

## 4.3. Логирование