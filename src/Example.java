import com.emr.logging.Logger;
import com.emr.logging.LogLevel;

public class Example {
    public static void main(String[] args) {
        Logger logger = new Logger(LogLevel.INFO);

        logger.debug("This is a debug message.");
        logger.info("App started.");
        logger.warn("This is a warning message.");
        logger.error("This is an error message.");

        logger.close(); 
    }
}
