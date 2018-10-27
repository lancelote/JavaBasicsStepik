package week4.hw4;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {
    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger parentLogger = Logger.getLogger("org.stepic.java");
        parentLogger.setLevel(Level.ALL);
        parentLogger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new XMLFormatter());
        consoleHandler.setLevel(Level.ALL);

        parentLogger.addHandler(consoleHandler);
    }
}
