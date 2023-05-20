package com.zerobank.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * A Utility class that load the key value pair inside config.properties file
 * into Properties object and provide single method called
 * read to get the value out of the properties file we created.
 */
public class ConfigurationReader {
    //declare properties object as class level so it can be accessible in static method

    private static Properties properties;

    //we want to only load the file once,
    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }


}
