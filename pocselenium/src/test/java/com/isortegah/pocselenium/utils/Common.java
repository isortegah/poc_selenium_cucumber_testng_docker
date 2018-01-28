package com.isortegah.poc_setecudo.utils;

import java.io.IOException;

/**
 *
 * @author ISORTEGAH
 */
public class Common {
    public static String browserType = null;
    public static String webdriver = null;
    
    static{
        try{
            browserType = ConfigPropertiesUtils.getInstance().getValue("browserType");
            webdriver = ConfigPropertiesUtils.getInstance().getValue("webdriver");
            
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
