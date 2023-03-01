package ui.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {
    public static String getDataProperties(String key) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream("C:\\src\\Book-Store-Application\\src\\test\\resources\\config_credential.properties");
            properties.load(fileInputStream);
            properties.getProperty("userName");
            properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
