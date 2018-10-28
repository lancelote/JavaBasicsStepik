# 5. Ввод-вывод, доступ к файловой системе

## 5.1. Доступ к файловой системе

### `java.io.File`

```
// on Windows
File javaExecutable = new File("C:\\jdk1.8.0_60\\bin\\java.exe");

File networkFolder = new File("\\\\server\\share");

// on Unix
File lsExecutable = new File("/usr/bin/ls");
```

### Сборка пути

```
String sourceDirName = "src";
String mainFileName = "Main.java";

String mainFilePath = sourceDirName + File.separator + mainFileName;

File mainFile = new File(sourceDirName, mainFileName);
```

### Абсолютные и относительные пути

```
File absoluteFile = new File("/usr/bin/java");
absoluteFile.isAbsolute();  // true
absoluteFile.getAbsolutePath();  // "/usr/bin/java"
```

```
File relativeFile = new File("readme.txt");
relativeFile.isAbsolute();  // false
relativeFile.getAbsolutePath();  // "/home/stepik/readme.txt"
relativeFile.getAbsoluteFile();  // Will return a File instance
```

Путь для относительных файлов разрешается относительно рабочей директории Java процесса.

### Разбор пути

```
File file = new File("/usr/bin/java");

String path = file.getPath();  // "/usr/bin/java"

String name = file.getName();  // "java"

String parent = file.getParent():  // "/usr/bin"
```

### Канонические пути

```
File file = new File("./prj/../symlink.txt");

String canonicalPath = file.getCanonicalPath();  // "/home/stepik/readmt.txt"
```

Может быть вызван `java.io.IOException`.

### Работа с файлами

```
File java = new File("/usr/bin/java");
java.exists();  // true
java.isFile();  // true
java.isDirectory();  // false
java.length();  // 1536
java.lastModified();  // 123191480500
```

### Работа с директориями

```
File usrbin = new File("/usr/bin");
usrbin.exists();  // true
usrbin.isFile();  // false
usrbin.isDirectory();  // true
usrbin.list();  // String[] or null
usrbin.listFiles();  // File[] or null
```

### Фильрация файлов

```
File[] javaSourceFiles = dir.listFiles(f -> f.getName().endWith(".java"));
```

Фильтр это объект реализующий один из двух интерфейсов:

```
java.io.FileFilter:
    boolean accept(File pathname)

java.io.FilenameFilter:
    boolean accept(File dir, String name)
```

### Создание файла

```
try {
    boolean success = file.createNewFile();
} catch (IOException e) {
    // handle error
}
```

### Создание директории

```
File dir = new File("a/b/c/d");
boolean success = dir.mkdir();
bookean success2 = dir.mkdirs();
```

### Удаление файла или директории

```
boolean success = file.delete();
```

### Переименование или перемещение файла

```
boolean success = file.renameTo(targetFile);
```

### `java.nio.file.Path`

```
Path path = Paths.get("prj/stepik");

File fromPath = path.toFile();

Path fromFile = fromPath.toPath();
```

#### Разбор пути

```
Path java = Path.get("/usr/bin/java");
java.isAbsolute();   // true
java.getFileName();  // java
java.getParent();    // /usr/bin

java.getNameCount();  // 3
java.getName(1);      // bin
java.resolveSibling("javap");  // /usr/bin/javap
java.startsWith("/usr");       // true
Paths.get("/usr").relativize(java);  // bin/java
```

#### Работа с файлами

```
Path java = Paths.get("/usr/bin/java");
Files.exists(java);  // true
Files.isRegularFile(java);  // true
Files.size(java);  // 1536
Files.getLastModifiedTime(java).toMillis();  // 1231914805000
Files.copy(java, Paths.get("/usr/bin/java_copy"), StandardCopyOption.REPLACE_EXISTING);
```

#### Работа с директориями

```
Path usrbin = Paths.get("/usr/bin");
Files.exists(usrbin);       // true
Files.isDirectory(usrbin);  // true

try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(usrbin)) {
    for (Path child : dirStream) {
        System.out.println(child);
    }
}
```

#### Создание директорий

```
Path dir = Paths.get("a/b/c/d");

Files.createDirectory(dir);

Files.createDirectories(dir);
```

#### Рекурсивное удаление

```
Path directory = Path.get("/tmp");

Files.walkFileTree(direcotry, new SimpleFileVisitor<Path>() {
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc == null) {
            Files.delete(dir);
            return FileVisitResult.CONTINUE;
        } else {
            throw exc;
        }
    }
}
```

#### Виртуальные файловые системы

```
Path zipPath = Paths.get("jdk1.8.0_60/src.zip");

try (FileSystem zipfs = FileSystem.newFileSystem(zipPath, null)) {
    for (Path path : zipfs.getRootDirectories()) {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        }
    }
}
```

## 5.2. Потоки байт

## 5.3. Потоки символов

## 5.4. Продвинутые возможности