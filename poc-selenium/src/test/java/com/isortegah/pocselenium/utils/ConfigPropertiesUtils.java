package com.isortegah.pocselenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author ISORTEGAH
 */
public class ConfigPropertiesUtils {
    private static ConfigPropertiesUtils instance = null;
    private Properties configProperties;
    
    private ConfigPropertiesUtils() throws IOException {
        configProperties = new java.util.Properties();
        FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config//config.properties");
        configProperties.load(ip);
    }
    
    public static synchronized ConfigPropertiesUtils getInstance()throws IOException {
        if (instance == null)
            instance = new ConfigPropertiesUtils();
        return instance;
    }
    
    public String getValue(String propKey){
        return configProperties.getProperty(propKey);
    }
}
