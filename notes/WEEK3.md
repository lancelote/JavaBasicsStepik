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

## 3.4. Наследование. Класс Object

## 3.5. Абстрактные классы и интерфейсы
