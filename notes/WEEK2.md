# 2. Базовый синтаксис Java

## 2.1. Примитивные типы

 - `boolean`
 - `char`
 - `byte`, `short`, `int`, `long`
 - `float`, `double`

Переменные ссылочных типов представляют собой ячейку памяти, содержащую ссылку на участок памяти, представляющий
собой объект.

Ссылка может быть пустой, для этого переменной присваивается значение `null`

### Целочисленные типы

 - `byte` - 8 бит, диапазон -128..+127
 - `short` - 16 бит, диапазон -2^15..+2^15-1
 - `int` - 32 бит, диапазон -2^31..+2^31-1
 - `long` - 64 бит, диапазон -2^63..+2^63-1

### char

 - `char` - 16 бит, беззнаковый, 0..2^16 - 1
 - Представляет номер символа в кодировке юникода

```
char literal = 'a'
char tab = '\t'
```

### Вещественные типы

 - `float` - 32 бит, 1 знак, 23 мантисса, 8 экспонента
 - `double` - 64 бит, 1 знак, 52 мантиса, 11 экспонента

Явное указание:
```
float floatWithSuffix = 36.6f;
double doubleWithSuffix = 36.6d;
```

Особые случаи:
```
double positiveInfinity = 1.0 / 0.0;
double negativeInfinity = -1.0 / 0.0;
double nan = 0.0 / 0.0;
boolean notEqualInself = nan != nan;
```

### Класс Math

```
double s = Math.sin(Math.PI);
double q = Math.sqrt(16);
double r = Math.ceil(1.01);
int a = Math.abs(-13);
int m = Math.max(10, 20);
```

### Длинная арифметика

```
import java.math.*;

BigInteger two = BigInteger.valueOf(2);
BigInteger powerOfTwo = two.pow(100);

BigDecimal one = BigDecimal.valueOf(1);
BigDecimal divisionResult = one.divide(new BigDecimal(powerOfTwo));
```

## 2.2. Преобразование типов

### Неявное преобразование

Многие преобразования типов можно выполнять неявно присваивая переменной с одним типом значение другого типа.

### Явное приведение

При потери точности:

```
int intValue = 1024;
byte byteValue = (byte) intValue;  // 0 - отбрасываются лишние старшие биты

double pi = 3.14;
int intFromDouble = (int) pi;  // 3 - отбрасывается дробная часть

float largeFloat = 1e20f;
int intFromLargeFloat = (int) largeFloat;  // Максимальное представимое целое число

double largeDouble = 1e100;
float floatFromLargeDouble = (float) largeDouble;  // Бесконечность
```

### Автоматическое расширение

При использовании бинарных арифметических или побитовых операторов:

1. Если один из операндов `double`, то другой тоже будет к нему приведен
2. Если один из операндов `float`, то оба приводятся к `float`
3. Если один из операндов `long`, то оба приводятся к `long`
4. Иначе оба приводятся к типу `int`

### Классы-обертки

- boolean - Boolean
- byte - Byte
- short - Short
- int - Integer
- long - Long
- char - Character
- float - Float
- double - Double

```
int privitive = 0;
Integer reference = Integer.valueOf(primitive);  // boxing
int backToPrimitive = reference.intValue();      // unboxing
```

Нужны для:

- Хранения примитивных типов в коллекциях
- Нужно хранить факт отсутствия значения

## 2.3. Массивы и строки

## 2.4. Управляющие конструкции: условные операторы и циклы
