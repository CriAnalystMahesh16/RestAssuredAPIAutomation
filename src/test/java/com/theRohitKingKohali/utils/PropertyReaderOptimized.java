package com.theRohitKingKohali.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReaderOptimized {
    public static String readKey(String key) {

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/resource/data.properties");
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("Warning: No value found for key '" + key + "'");
            return null;
        }

        return properties.getProperty(key);
    }
}
