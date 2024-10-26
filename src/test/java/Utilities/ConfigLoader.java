package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Mini-FRC_BDD\\src\\test\\resources\\config\\dev_config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
