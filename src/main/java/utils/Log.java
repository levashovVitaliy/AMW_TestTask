package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.TestListenerAdapter;


public class Log /*extends TestListenerAdapter */{

    private static final Logger logger = LogManager.getLogger(Log.class);


    public static <T extends Object> void info(T message) {
        logger.info(String.valueOf(message));
    }

    public static <T extends Object> void warn(T message) {
        logger.warn(String.valueOf(message));
    }

    public static <T extends Object> void error(T message) {
        logger.error(String.valueOf(message));
    }
}
