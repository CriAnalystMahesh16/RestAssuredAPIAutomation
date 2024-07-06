package com.theRohitKingKohali.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    public static String readKey(String key) {

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/ com.theRohitKingKohali.utils");
            properties.load(fileInputStream);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return properties.getProperty(key);
    }

}
