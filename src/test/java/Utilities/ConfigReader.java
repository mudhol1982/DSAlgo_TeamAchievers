package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Load the config.properties file from the classpath
    public static void loadConfig() throws IOException {
        // Using ClassLoader to load the file from the classpath
        InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("Config/config.properties");

        // If the file is not found, throw an exception
        if (inputStream == null) {
            throw new IOException("Config file not found in classpath");
        }

        // Load the properties from the file
        properties.load(inputStream);
    }

    // Get the browser type from the config file
    public static String getBrowserType() {
        return properties.getProperty("browser");
    }

    // Get the URL from the config file
    public static String getUrl() {
        return properties.getProperty("url");
    }
   
}

