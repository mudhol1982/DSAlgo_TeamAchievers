package Utilities;

//import java.util.logging.LogManager;
//import io.cucumber.core.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerLoad {
	
	 // Initialize the logger for the class
	private static final Logger logger = LogManager.getLogger(LoggerLoad.class);

     	 public static void info(String message) {

		 logger.info(message); 			

		 }

	 public static void warn(String message) {

		 logger.warn(message);

		}

	 public static void error(String message) {

		 logger.error(message);

		}

	 public static void fatal(String message) {

		 logger.fatal(message);

		}

	 public static void debug(String message) {

		 logger.debug(message);

		}



}

