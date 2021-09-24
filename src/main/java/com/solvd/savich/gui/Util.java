package com.solvd.savich.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    public final static String PATH_TO_PROPERTIES = "src/main/java/resources/testdata.properties";
    private final static Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static String getPropertiesValue(String key){
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)){
            properties.load(fileInputStream);
            return properties.getProperty(key,"default");
        } catch (IOException e) {
            LOGGER.error("Error in the program: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        }
        return "default";
    }
}
