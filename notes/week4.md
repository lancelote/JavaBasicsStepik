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

## 4.3. Логирование