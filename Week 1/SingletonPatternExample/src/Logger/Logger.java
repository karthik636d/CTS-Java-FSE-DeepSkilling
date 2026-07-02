package Logger;

public class Logger {
    private Logger() { }

    private static class LoggerHelper {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        System.out.println("Logger instance retrieved.");
        return LoggerHelper.INSTANCE;
    }
}