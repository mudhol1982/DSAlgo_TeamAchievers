package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import DriverManager.Driver_SetUp;

public class ConfigReader {

    private static Properties properties = new Properties();
    
    private static String browserType = null;

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

    // Get the Time Complexity URL from the config file
    public static String geturlTimeComplexity() {
        // Retrieve the value of "urlTimeComplexity" from the properties file
        return properties.getProperty("urlTimeComplexity");
    }
    
    // Get the DataStructuresIntroduction URL from the config file
    public static String geturlDataStructuresIntroduction() {
        // Retrieve the value of "urlDataStructuresIntroduction" from the properties file
        return properties.getProperty("urlDataStructuresIntroduction");
    }
        
    // Get the Practice Questions(DataStructuresIntroduction) URL from the config file
    public static String geturlPracticeQnsDSIntroPage() {
        // Retrieve the value of "urlDataStructuresIntroduction" from the properties file
        return properties.getProperty("urlDataStructuresIntroPracticeQns");
    }

    public static String getUrlTree() {
        return properties.getProperty("urlTree");
    }

    public static String getUrlGraph() {
        return properties.getProperty("urlGraph");
    }
    

    public static String getUrlStack() {
    	return properties.getProperty("urlStack");
    }
    
    public static String getUrlQueue() {
    	return properties.getProperty("urlQueue");
    }
    
    public static String getUrlHome() {
        return properties.getProperty("urlHome");
    }

    public static String getUserName() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getUrlLinkedList() {
        return properties.getProperty("urlLinkedList");
    }
    
    public static String getUrlArray() {
        return properties.getProperty("urlArray");
    }

    // Method to load the browser type and initialize WebDriver based on the config file
    public static void initializeDriverFromConfig() throws Exception {
        // Load the configuration properties
        loadConfig();

        // Get the browser type from the properties file
        String browser = getBrowserType();

        // Initialize the WebDriver using the browser type from the config file
        Driver_SetUp.initializeBrowser(browser);
    }

	public static Properties initializeprop() {
		Properties prop = new Properties();
		File profile = new File(
				System.getProperty("user.dir") + "/src/test/resources/Config/config.properties");

		try (FileInputStream fis = new FileInputStream(profile)) {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}


	
	public static void setBrowserType(String browser) {
		browserType = browser;
	}
}

