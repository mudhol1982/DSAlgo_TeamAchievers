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
    public String getUserName() {
		return properties.getProperty("username");
	}
	public String getPassword() {
		return properties.getProperty("password");
	}


	
	 public static String getUrlLinkedList() {
	    	return properties.getProperty("urlLinkedList");
	    }
	 	
	 public static String getUrlArray() {
	    	return properties.getProperty("urlArray");
	    }
	    
}
