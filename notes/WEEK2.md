# 2. Базовый синтаксис Java

## 2.1. Примитивные типы

 - `boolean`
 - `char`
 - `byte`, `short`, `int`, `long`
 - `float`, `double`

Переменные ссылочных типов представляют собой ячейку памяти, содержащую ссылку на участок памяти, представляющий
собой объект.

Ссылка может быть пустой, для этого переменной присваивается значение `null`

### boolean

В Java поддерживается 4 операции с `boolean`:

 - "не" - `boolean haveSpareTime = !isBusy;`
 - "и" - `boolean canGoToPark = haveSpareTime &&  weatherIsGood;`
 - "или" - `boolean hadGoodTime = learnedJavaOnStepik || wentToPark;`
 - "исключающее или" - `boolean tastesGood = addedKetchup ^ addedHoney;`
 
Вычисление по полной схеме для "и" и "или" доступно через операторы `&` и `|`.

Сокращенный вид записи (использует полную схему вычисления):

```
value &= expression;
value |= expression;
value ^= expression;
```

### Целочисленные типы

 - `byte` - 8 бит, диапазон -128..+127
 - `short` - 16 бит, диапазон -2^15..+2^15-1
 - `int` - 32 бит, диапазон -2^31..+2^31-1
 - `long` - 64 бит, диапазон -2^63..+2^63-1

Разные способы записи:

```
int decimal = 99;
int octal = 0755;
int hex = 0xFF;
int binary = 0b101;
int tenMillion = 10_000_000;
int tenBillion = 10_000_000_000L;
```

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

Способы записи:

```
double simple = -1.234;
double exponential = -123.4e-2;
double hex = 0x1.Fp10;
float floatWithSuffix = 36.6f;
double withSuffix = 4d;
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

```
byte byteValue = 123;
short shortValue = byteValue;
int intValue = byteValue;
long longValue = byteValue;

char charValue = '@';
int intFromChar = charValue;
long longFromChar = charValue;

float floatFromLong = longValue;
double doubleFromFloat = floatFromLong;
double doubleFromInt = intValue;
```

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

### Неявное приведение

```
byte a = 1;
a += 3
// a = (byte) (a + 3);

byte b = -1;
b >>>= 7;
// b = (byte) (b >>> 7);
```

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

### Конвертация в строку и обратно

```
long fromString = Long.parseLong("12345");
String fromLong = Long.toString(12345);
String concatenation = "area" + 51;
```

### Полезные методы

```
short maxShortValue = Short.MAX_VALUE;

int bitCount = Integer.bitCount(123);

boolean isLetter = Character.isLetter('a');

float floatInfinity = Float.POSITIVE_INFINITY;

double doubleNaN = Double.NaN;

boolean isNaN = Double.isNaN(doubleNaN);
```

## 2.3. Массивы и строки

### Массивы

```
int[] numbers = new int[100];

String[] args = new String[1];

boolean bits[] = new boolean[0];
```

### Массив ненулевых значений

```
int[] numbers = new int[] {1, 2, 3, 4, 5};

boolean[] bits = new boolean[] {true, false};

// Можно опустить new и тип массива в variable declaration
char[] digits = {'0', '1', '2', '3', '4', '5'};
```

### Работа с массивом

```
int[] numbers = {1, 2, 3, 4, 5};

int arrayLength = numbers.length;

int firstNumber = numbers[0];

int lastNumber = numbers[arrayLength - 1];

int indexOutOfBounds = numbers[5];
```

### Многомерные массивы

```
int [][] matrix1 = new int[2][2];
int [][] matrix2 = {{1, 2}, {3, 4}};

int[] fristRow = matrix2[0];      // Get firt row
int someElement = matrix2[1][1];  // Get one element
```

### Ступенчатые массивы

```
int[][] triangle = {
    {1, 2, 3, 4, 5},
    {6, 7, 8, 9},
    {10, 11, 12},
    {13, 14},
    {15}
};

int theSecondRowLength = triangle[1].length;
```

### Объявление метода, принимающего переменное число параметров

```
static int maxArray(int[] numbers) { ... };
maxArray(new int[] {1, 2, 3});

static int maxVarargs(int... numbers) { ... };
maxVarargs(1, 2, 3);  // Компилятор сам упакует аргументы в массив
```

### Сравнение двух массивов

```
import Java.util.Arrays;

int[] a = {1, 2, 3};
int[] b = {4, 5, 6};

boolean equals1 = a == b;                  // Сравнение ссылок - ссылаются ли на один и тот же объект
boolean equals2 = a.equals(b);             // Для массивов также сравнивает ссылки
boolean equals3 = Array.equals(a, b);      // Хорошо работает для одномерных массивов
boolean equals4 = Array.deepEquals(a, b);  // Решение для многомернх массивов
```

### Распечатка массива

```
int[] a = {1, 2, 3};

// Плохой метод
System.out.println(a);

// Работает с одномерными массивами
System.out.println(Arrays.toString(a));

// Работает с многомерными массивами
System.out.println(Arrays.deepToString(a));
```

### Строки

```
String hello = "Hello";
String specialChars = "\r\n\t\"\\";
String empty = "";

char[] charArray = {'a', 'b', 'c'};
String string = new String(charArray);
char[] charsFromString = string.toCharArray();

// Строка не должны заканчиваться нулевым символом
String zeros = "\u0000\u0000";
```

### Неизменяемость строк

```
String s = "stringIsImmutable";

int length = s.length();

char firstChar = s.charAt(0);

boolean endsWithTable = s.endsWith("table");

boolean containsIs = s.contains("Is");

String substring = s.substring(0, 6);

String afterReplace = s.replace("Imm", "M");

String allCapitals = s.toUpperCase();
```

Соединение двух строк также создает новую:

```
String hello = "Hello ";
String world = "world!";
String helloWorld = hello + world;
```

Что эквивалентно:

```
StringBuilder sb = new StringBuilder();
sb.append(hello);
sb.append(world);
String helloWorld = sb.toString();
```

### Сравнение строк

Нужно делать через метод, чтобы не проверять ссылки на один объект:

```
boolean contentEquals = s1.equals(s2);

boolean contentEqualsIgnoreCase = s1.equalsIgnoreCase(s2);
```

## 2.4. Управляющие конструкции: условные операторы и циклы

### Условный оператор

```
if (weatherIsGood) {
    walkInThePark();
} else {
    learnJavaOnStepic();
}
```

### Тернарный условный оператор

```
System.out.println("Weather is " + (weatherIsGood ? "good" : "bad"));
```

### Оператор switch

```
switch (digit) {
    case 0:
        text = "zero";
        break;
    
    case 1:
        text = "one";
        break;
    
    // ...
    
    default:
        text = "???";
}
```

### Цикл while

```
while (haveTime() && haveMoney()) {
    goShopping();
}
```

### Цикл do while

```
do {
    goShopping();
} while (haveTime() && haveMoney());
```

### Цикл for

```
for (int i = 0; i < args.length; i++) {
    System.out.println(args[i]);
}
```

### Цикл foreach

```
for (String arg : args) {
    System.out.println(arg);
}
```

### Оператор break

```
boolean found = false;

for (String element : haystack) {
    if (needle.equals(element)) {
        found = true;
        break;
    }
}
```

### Оператор continue

```
int count = 0;

for (String element : haystack) {
    if (!needle.equals(element)) {
        continue;
    }
    count++;
}
```

### Метки

```
boolean found = false;

outer:
for (int[] row : matrix) {
    for (int x : row) {
        if (x > 100) {
            found = true;
            break outer;
        }
    }
}
```
