package ua.olx.utils;

import java.io.*;
import java.util.Properties;

public class LoadProperties {

    public static String getProperty(String key) {
        String value = null;
        try {
            File file = new File("src/main/resources/config.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            value = properties.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
