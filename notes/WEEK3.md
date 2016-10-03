# 3. Объекты, классы и пакеты в Java

## 3.1. Основы ООП

- Абстракция
- Инкапсуляция
- Наследование
- Полиморфизм

## 3.2. Пакеты и модификаторы доступа

### Пакеты

```
package org.stepic.java;  // Принадлежность класса пакету

public class HelloWorld {
    // ...
}
```

Полное имя класса из примера выше: `org.stepic.java.HelloWorld`.

В отсутствие директивы принадлежность пакету класс принадлежит пакету по умолчанию.

Классы того же пакета могут ссылаться друг на друга по короткому имени. Классы разных пакетов должны ссылаться друг на
друга по полному имени или использовать импорт:

```
import org.stepic.java.HelloWorld;

import java.util.*;
```

### import static

Используется для импорта статических полей и методов:

```
import static java.lang.Math.sqrt;

import static java.lang.System.out;
```

### Пакеты стандартной библиотека

```
java.lang
java.io
java.nio
java.math
java.time
java.util
java.util.regex
javax.xml
...
```

### Пакеты для стороннего кода

```
org.stepik.java
com.google.common
org.apache.maven
com.intellij.idea
net.sf.json
io.netty
...
```

### Модификаторы доступа

```java
public class ModifiedDemo {
    
    public static void visibleEverywhere() {}
    
    protected static void inSubclasses() {}
    
    static void inPackage() {}
    
    private void inClass() {}
}
```

## 3.3. Объявления класса

```java
package java.lang;

public final class Integer {}
```

В файле может быть только один public класс. Ключевое слово final в объявлении класса означает что от данного класса
нельзя наследоваться.

### Поля

```java
package java.lang;

public final class Integer {
    private final int value;
}
```

Модификатор final у поля означает что полю можно присвоить значение только один раз, после чего изменения будут
запрещены.

### Конструкторы

```java
package java.lang;

public final class Integer {
    
    private final int value;
    
    public Integer(int value) {
        this.value = value;
    }
}
```

Без объявления конструктора в классе будет создан конструктор по умолчанию. Запрет на создание экземпляров класса:

```java
package java.lang;

public final class Math {
    private Math() {}
}
```

В классе может быть несколько конструкторов с разными параметрами:

```java
package java.math;

public class BigInteger {
    
    public BigInteger(String val) {
        this(val, 10);  // Вызов другого конструктора
    }
    
    public BigInteger(String val, int radix) {}
}
```

Для реализации деструктора стоит завести отдельный метод close и вызвать его самостоятельно:

```java
package java.io;

public class FileInputStream {
    
    protected void finalize() {
        // Auto cleanup
    }
    
    public void close() {}
}
```

### Методы

```java
package java.lang;

public final class Integer {
    
    private final int value;
    
    public int intValue() {
        return value;
    }
}
```

Модификатор final у метода означает что данный метод не может быть переопределен в классах-наследниках.

### Методы с одинаковыми именами

В классе может быть несколько методов с одинаковыми именами, но разным набором параметров:

```java
package java.lang;

public final class String {
    
    public int indexOf(int ch) {
        return indexOf(ch, 0);
    }
    
    public int indexOf(int ch, int fromIndex) {}
}
```

### Статические поля и методы

```java
package java.lang;

public final class Integer {
    
    public static final int MIN_VALUE = 0x80000000;  // Константа
    
    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance);
    }
}
```

### Перечисления

```java
public class BadExample {
    public static final int MONDAY = 1;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 1;
    public static final int THURSDAY = 1;
    public static final int FRIDAY = 1;
    public static final int SATURDAY = 1;
    public static final int SUNDAY = 1;
}
```

Пример с перечислением:

```java
package java.time;

public enum DayOfWeek {
    MONDAY,  // public static final
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
    
    // Дальше можно объявлять поля и методы как в обычном классе
    // Можно создать конструктор и передавать аргументы в элементы выше
}
```

Методы:

```
for (DayOfWeek day : DayOfWeek.values()) {
    System.out.println(day.ordinal() + " " + day.name());
}
```

- `name()` - возвращает строку - имя элемента как в исходном коде
- `ordinal()` - возвращает число - порядковый метод элемента перечисления, начиная с нуля
- `values()` - озвращает массив возможных элементов перечисления

### Аннотации

```java
package java.lang;

public final class Character {
    
    @Deprecated
    public static boolean isJavaLetter(char c) {}
    
    @SuppressWarnings("unchecked")
    public static final Class<Character> TYPE = (Class<Character>) Class.getPrivitiveClass("char");
}
```

## 3.4. Наследование. Класс Object

## 3.5. Абстрактные классы и интерфейсы
